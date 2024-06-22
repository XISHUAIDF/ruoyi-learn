package com.ruoyi.competition.config;

import io.minio.*;
import io.minio.errors.MinioException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Component
public class
MinioTemplate implements InitializingBean {

    @Autowired
    private OssConfig ossConfig;

    private MinioClient minioClient;

    static  final Logger logger = LoggerFactory.getLogger(MinioTemplate.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        this.minioClient =  MinioClient.builder().endpoint(ossConfig.getEndpoint())
                .credentials(ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret())
                .build();
    }


    /**
     * 删除文件
     *
     * @param objectName 文件名称
     * @throws Exception https://docs.minio.io/cn/java-client-api-reference.html#removeObject
     */
    public void removeObject(String objectName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder().object(objectName).bucket(ossConfig.getBucket()).build());
    }



    public void uploadMinio(byte[] bytes, String filePath, String contentType) throws IOException {
        InputStream input = null;
        try {
            input = new ByteArrayInputStream(bytes);
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(ossConfig.getBucket())
                            .contentType(contentType)
                            .stream(input, input.available(), -1)
                            .object(filePath)
                            .build()
            );
        } catch (Exception e) {
            logger.error("minio上传文件错误：", e);
        } finally {
            if (Objects.nonNull(input)) {
                input.close();
            }
        }
    }
    public InputStream downloadFile(String objectName, String targetDirectory) throws Exception {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(ossConfig.getBucket())
                            .object(objectName)
                            .build()
            );
        } catch (MinioException e) {
            System.err.println("Error occurred: " + e);
            throw e;
        }
    }
}
