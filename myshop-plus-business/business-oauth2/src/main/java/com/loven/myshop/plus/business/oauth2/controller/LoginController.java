package com.loven.myshop.plus.business.oauth2.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.google.common.collect.Maps;
import com.loven.myshop.plus.business.oauth2.controller.fallback.LoginControllerFallback;
import com.loven.myshop.plus.cloud.message.api.MessageProducer;
import com.loven.myshop.plus.cloud.message.dto.AdminLoginLog;
import com.loven.myshop.plus.common.constant.CodeStatus;
import com.loven.myshop.plus.common.utils.MapperUtils;
import com.loven.myshop.plus.common.utils.OkHttpClientUtils;
import com.loven.myshop.plus.business.oauth2.dto.LoginParam;
import com.loven.myshop.plus.common.dto.ResponseResult;
import com.loven.myshop.plus.common.utils.RequestInfoUtils;
import com.loven.myshop.plus.common.utils.dto.IpInfo;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import okhttp3.*;
import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * 登录
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/21.
 */
@RestController
@RequestMapping("user")
public class LoginController {
    public static ThreadLocal<UmsAdmin> threadLocal = new ThreadLocal<>();

    @Value("${server.port}")
    private int port;
    @Value("${business.oauth2.grant_type}")
    private String grantType;
    @Value("${business.oauth2.client_id}")
    private String clientId;
    @Value("${business.oauth2.client_secret}")
    private String clientSecret;

    @Reference(version = "1.0.0")
    private MessageProducer producer;

    @Resource(name = "userDetailsServiceBean")
    private UserDetailsService userDetailsService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource(name = "redisTokenStore")
    private TokenStore tokenStore;
    /**
     * description
     *
     * @author loven
     * @date  16:58:02
     * @param param {@link String}
     * @return common.dto.ResponseResult<java.util.Map<java.lang.String,java.lang.Object>> {@link ResponseResult <java.util.Map<java.lang.String,java.lang.Object>>}
     * @throws
     */
    @PostMapping("login")
    @SentinelResource(value = "login", fallback = "loginFallback",fallbackClass = LoginControllerFallback.class)
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam param, HttpServletRequest request) {
        try {
            // 封装返回的结果集
            Map<String, Object> result = Maps.newHashMap();
            // 验证密码是否正确
            UserDetails userDetails = userDetailsService.loadUserByUsername(param.getUsername());
            if (userDetails == null || !passwordEncoder.matches(param.getPassword(), userDetails.getPassword())) {
                return ResponseResult.fail(CodeStatus.FAIL, "用户名或密码错误！");
            }
            UmsAdmin umsAdmin = threadLocal.get();
            // 通过 HTTP 客户端请求登录接口
            Map<String, String> params = Maps.newHashMap();
            params.put("username", param.getUsername());
            params.put("password", param.getPassword());
            params.put("grant_type", grantType);
            params.put("client_id", clientId);
            params.put("client_secret", clientSecret);

            try {
                // 解析响应结果封装并返回
                Response response = OkHttpClientUtils.getInstance().postData("http://localhost:"+port+"/oauth/token", params);
                String jsonString = Objects.requireNonNull(response.body()).string();
                Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
                String token = String.valueOf(jsonMap.get("access_token"));
                if(StringUtils.isNotBlank(token)){
                    sendLoginLog(request, umsAdmin);
                    result.put("token", token);
                    return ResponseResult.success(result, "登录成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            threadLocal.remove();
        }
        return ResponseResult.fail(CodeStatus.FAIL, "登录失败");
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("logout")
    public ResponseResult<Void> logout(HttpServletRequest request){
        String authString = request.getHeader("authorization");
        String token = authString.split(" ")[1];
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(accessToken);
        return ResponseResult.success("注销成功！");
    }

    private void sendLoginLog(HttpServletRequest request, UmsAdmin umsAdmin){
        String ip = RequestInfoUtils.getIpAddr(request);
        IpInfo ipInfo = RequestInfoUtils.getIpInfo(ip);
        String userAgent = RequestInfoUtils.getBrowser(request).getName();

        AdminLoginLog log = new AdminLoginLog();
        log.setAdminId(umsAdmin.getId());
        log.setCreateTime(new Date());
        log.setAddress(ipInfo.getCountry() + " " +ipInfo.getCity());
        log.setUserAgent(userAgent);
        log.setIp(ip);
        producer.sendAdminLoginLog(log);
    }
}
