package com.ruoyi.competition.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class OssConfig {

    @Value("${ruoyi.oss.endpoint}")
    private String endpoint;
    @Value("${ruoyi.oss.bucket}")
    private String bucket;
    @Value("${ruoyi.oss.access-key-id}")
    private String accessKeyId;
    @Value("${ruoyi.oss.access-key-secret}")
    private String accessKeySecret;
    @Value("${ruoyi.oss.type}")
    private Integer ossType;
    /**
     * 最大上传长度单位m，默认20M
     */
    @Value("${biz.oss.maxLength:20}")
    private Integer maxLength;
}
