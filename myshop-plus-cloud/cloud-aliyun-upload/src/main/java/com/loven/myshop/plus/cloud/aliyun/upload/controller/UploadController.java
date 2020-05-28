package com.loven.myshop.plus.cloud.aliyun.upload.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.loven.myshop.plus.cloud.aliyun.upload.dto.FileInfo;
import com.loven.myshop.plus.common.constant.CodeStatus;
import com.loven.myshop.plus.common.dto.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/25.
 */
@RestController
@RequestMapping(value = "upload")
public class UploadController {

    private static final String ENDPOINT = "oss-cn-shenzhen.aliyuncs.com";
    private static final String ACCESS_KEY_ID = "LTAIUEM4x1Y0qTOO";
    private static final String ACCESS_KEY_SECRET = "XVRECYNWqS7uzssIXeNrcgKIamBjTh";
    private static final String BUCKET_NAME = "javasite";

    /**
     * 文件上传
     *
     * @param multipartFile @{code MultipartFile}
     * @return {@link ResponseResult<FileInfo>} 文件上传路径
     */
    @PostMapping(value = "icon")
    public ResponseResult<FileInfo> upload(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        assert fileName != null;
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newName = UUID.randomUUID() + "." + suffix;

        OSS client = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        try {
            client.putObject(new PutObjectRequest(BUCKET_NAME, newName, new ByteArrayInputStream(multipartFile.getBytes())));
            // 上传文件路径 = http://BUCKET_NAME.ENDPOINT/自定义路径/fileName
            return ResponseResult.success(new FileInfo("http://" + BUCKET_NAME + "." + ENDPOINT + "/" + newName),"文件上传成功");
        } catch (IOException e) {
            return ResponseResult.fail(CodeStatus.FAIL, "文件上传失败，请重试");
        } finally {
            client.shutdown();
        }
    }

}
