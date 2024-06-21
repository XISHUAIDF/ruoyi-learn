package com.ruoyi.competition.mapper;


import com.ruoyi.competition.domain.Refmfiles;

import java.util.List;


/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-20
 */
public interface RefmfilesMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param fileId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRefmfilesByFileId(Long fileId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param fileIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRefmfilesByFileIds(Long[] fileIds);
}
