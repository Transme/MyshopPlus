package com.loven.myshop.plus.business.user.controller;

import com.loven.myshop.plus.business.user.dto.ModifieInfo;
import com.loven.myshop.plus.business.user.dto.UserInfo;
import com.loven.myshop.plus.business.user.service.UserService;
import com.loven.myshop.plus.common.constant.CodeStatus;
import com.loven.myshop.plus.common.dto.ResponseResult;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/22.
 */
@RestController
@RequestMapping("profile")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("info")
    public ResponseResult<UserInfo> getUserInfo(){
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UmsAdmin umsAdmin = userService.selectOne(username);
        UserInfo userInfo = new UserInfo();
        if(umsAdmin != null){
            userInfo.setName(umsAdmin.getUsername());
            userInfo.setAvatar(umsAdmin.getIcon());
            userInfo.setNickName(umsAdmin.getNickName());
            return ResponseResult.success(userInfo);
        }
        return ResponseResult.fail(CodeStatus.FAIL, "获取用户信息失败");
    }

    @GetMapping("info/{username}")
    public ResponseResult<UmsAdmin> selectOne(@PathVariable String username){
        UmsAdmin umsAdmin = userService.selectOne(username);
        if(umsAdmin != null){
            return ResponseResult.success(umsAdmin);
        }
        else{
            return ResponseResult.fail(CodeStatus.FAIL, "获取用户信息失败!");
        }
    }

    @PostMapping("/info")
    public ResponseResult<UmsAdmin> selectOne(@RequestBody UmsAdmin admin){
        UmsAdmin umsAdmin = userService.selectOneByEntity(admin);
        if(umsAdmin != null){
            return ResponseResult.success(umsAdmin);
        }
        else{
            return ResponseResult.fail(CodeStatus.FAIL, "获取用户信息失败!");
        }
    }

    @GetMapping("/info/all")
    public ResponseResult<List<UmsAdmin>> selectAll(){
        List<UmsAdmin> list = userService.selectAll();
        return ResponseResult.success(list);
    }

    @PostMapping("/modified/info")
    public ResponseResult<Void> modifiedInfo(@RequestBody ModifieInfo info){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if(! username.equals(info.getUsername())){
            return ResponseResult.fail(CodeStatus.ILLEGAL_USERNAME, "非法的用户名");
        }
        int result = userService.modifiedInfo(info);
        //更新成功
        if(result > 0){
            return ResponseResult.success("更新用户信息成功！");
        }

        //更新失败
        else{
            return ResponseResult.fail(CodeStatus.FAIL,"更新用户信息失败！");
        }
    }

    @PostMapping("/modified/icon")
    public ResponseResult<Void> modifiedIcon(@RequestBody ModifieInfo modifieInfo){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if(! username.equals(modifieInfo.getUsername())){
            return ResponseResult.fail(CodeStatus.ILLEGAL_USERNAME, "非法的用户名");
        }
        int result = userService.modifiedIcon(modifieInfo);
        //更新成功
        if(result > 0){
            return ResponseResult.success("更新头像成功！");
        }

        //更新失败
        else{
            return ResponseResult.fail(CodeStatus.FAIL,"更新头像失败！");
        }
    }

    @PostMapping("/modified/password")
    public ResponseResult<Void> modifiedPassword(@RequestBody ModifieInfo modifieInfo){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if(! username.equals(modifieInfo.getUsername())){
            return ResponseResult.fail(CodeStatus.ILLEGAL_USERNAME, "非法的用户名");
        }
        modifieInfo.setPassword(encoder.encode(modifieInfo.getPassword()));
        int result = userService.modifiedPassword(modifieInfo);
        //更新成功
        if(result > 0){
            return ResponseResult.success("更新密码成功！");
        }

        //更新失败
        else{
            return ResponseResult.fail(CodeStatus.FAIL,"更新密码失败！");
        }
    }
}
