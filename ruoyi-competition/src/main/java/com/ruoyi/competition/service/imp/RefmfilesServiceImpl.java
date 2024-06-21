package com.ruoyi.competition.service.imp;


import com.ruoyi.competition.config.MinioTemplate;
import com.ruoyi.competition.domain.Refmfiles;
import com.ruoyi.competition.mapper.RefmfilesMapper;
import com.ruoyi.competition.service.IRefmfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-20
 */
@Service
public class RefmfilesServiceImpl implements IRefmfilesService
{
    @Autowired
    private MinioTemplate minioTemplate;
    @Autowired
    private RefmfilesMapper refmfilesMapper;
    private static final String filePath_Prefix = "F:\\minioPath";
    /**
     * 查询【请填写功能名称】
     * 
     * @param fileId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Refmfiles selectRefmfilesByFileId(Long fileId)
    {
        return refmfilesMapper.selectRefmfilesByFileId(fileId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param refmfiles 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Refmfiles> selectRefmfilesList(Refmfiles refmfiles)
    {
        return refmfilesMapper.selectRefmfilesList(refmfiles);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param refmfiles 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRefmfiles(Refmfiles refmfiles)
    {
        return refmfilesMapper.insertRefmfiles(refmfiles);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param refmfiles 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRefmfiles(Refmfiles refmfiles)
    {
        return refmfilesMapper.updateRefmfiles(refmfiles);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param fileIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRefmfilesByFileIds(Long[] fileIds)
    {
        return refmfilesMapper.deleteRefmfilesByFileIds(fileIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param fileId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRefmfilesByFileId(Long fileId)
    {
        return refmfilesMapper.deleteRefmfilesByFileId(fileId);
    }


}

