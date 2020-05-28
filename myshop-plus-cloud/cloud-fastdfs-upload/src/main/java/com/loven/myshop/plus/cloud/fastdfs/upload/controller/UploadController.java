package com.loven.myshop.plus.cloud.fastdfs.upload.controller;

import com.loven.myshop.plus.cloud.fastdfs.upload.dto.FileInfo;
import com.loven.myshop.plus.cloud.fastdfs.upload.service.StorageService;
import com.loven.myshop.plus.common.constant.CodeStatus;
import com.loven.myshop.plus.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/25.
 */
@RestController
@RequestMapping("upload")
public class UploadController {
    @Value("${fastdfs.base.url}")
    private String FASTDFS_BASE_URL;

    @Autowired
    private StorageService storageService;


    @RequestMapping(value = "icon", method = RequestMethod.POST)
    public ResponseResult<FileInfo> upload(MultipartFile multipartFile) {
        String path;
        path = writeFile(multipartFile);
        return ResponseResult.success(new FileInfo(path), "更新头像成功");
    }

    /**
     * 将图片写入指定目录
     *
     * @param multipartFile
     * @return 返回文件完整路径
     */
    private String writeFile(MultipartFile multipartFile) {
        // 获取文件后缀
        String oName = multipartFile.getOriginalFilename();
        assert oName != null;
        String extName = oName.substring(oName.lastIndexOf(".") + 1);

        // 文件存放路径
        String url = null;
        try {
            String uploadUrl = storageService.upload(multipartFile.getBytes(), extName);
            url = FASTDFS_BASE_URL + uploadUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回文件完整路径
        return url;
    }
}