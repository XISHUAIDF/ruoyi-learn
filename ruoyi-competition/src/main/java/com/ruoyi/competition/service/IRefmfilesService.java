package com.ruoyi.competition.service;


import com.ruoyi.competition.domain.Refmfiles;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-06-20
 */
public interface IRefmfilesService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param fileId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Refmfiles selectRefmfilesByFileId(Long fileId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param refmfiles 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Refmfiles> selectRefmfilesList(Refmfiles refmfiles);

    /**
     * 新增【请填写功能名称】
     * 
     * @param refmfiles 【请填写功能名称】
     * @return 结果
     */
    public int insertRefmfiles(Refmfiles refmfiles);

    /**
     * 修改【请填写功能名称】
     * 
     * @param refmfiles 【请填写功能名称】
     * @return 结果
     */
    public int updateRefmfiles(Refmfiles refmfiles);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param fileIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteRefmfilesByFileIds(Long[] fileIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param fileId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRefmfilesByFileId(Long fileId);


}
