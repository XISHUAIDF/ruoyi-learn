package com.ruoyi.competition.utils;

import cn.hutool.core.util.RandomUtil;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.competition.config.MinioTemplate;
import com.ruoyi.competition.domain.Refmfiles;
import com.ruoyi.competition.exception.OssException;
import com.ruoyi.competition.service.IRefmfilesService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
@Component
public class OssUtils {

    @Resource
    private MinioTemplate minioTemplate;

    @Resource
    private IRefmfilesService iRefmfilesService;
    private static final String filePath_Prefix = "F:\\minioPath";

    public String uploadRefmfiles(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new OssException("empty file");
        }
        Long randomId = RandomUtil.randomLong(100000, 999999);

        minioTemplate.uploadMinio(file.getBytes(), filePath_Prefix+randomId, file.getContentType());

        String fileName = file.getOriginalFilename();
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = loginUser.getUserId();
        Refmfiles refmfiles = new Refmfiles();
        refmfiles.setFileId(randomId);
        refmfiles.setFileName(fileName);
        refmfiles.setFilePath(filePath_Prefix+randomId);
        refmfiles.setFileSize(file.getSize());
        refmfiles.setParticipantsId(userId);
        iRefmfilesService.insertRefmfiles(refmfiles);
        return filePath_Prefix+randomId;

    };


    public Boolean downloadRefmfiles(Long fileId,String targetDirectory) throws Exception {
        Refmfiles refmfiles = new Refmfiles();
        refmfiles = iRefmfilesService.selectRefmfilesByFileId(fileId);
        minioTemplate.downloadFile(refmfiles.getFileName(),targetDirectory);
        return true;
    }




}
