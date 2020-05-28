package com.loven.myshop.plus.cloud.fastdfs.upload.configure;

import com.loven.myshop.plus.cloud.fastdfs.upload.factory.StorageFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by loven on 2020/5/12.
 */
@Configuration
public class FastDFSConfiguration {
    @Bean
    public StorageFactory storageFactory() {
        return new StorageFactory();
    }
}
