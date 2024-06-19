package com.ruoyi.competition.mapper;

import com.ruoyi.competition.domain.Evaluate;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author zjh
 * @date 2024-06-19
 */
public interface EvaluateMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Evaluate selectEvaluateById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param evaluate 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Evaluate> selectEvaluateList(Evaluate evaluate);

    /**
     * 新增【请填写功能名称】
     * 
     * @param evaluate 【请填写功能名称】
     * @return 结果
     */
    public int insertEvaluate(Evaluate evaluate);

    /**
     * 修改【请填写功能名称】
     * 
     * @param evaluate 【请填写功能名称】
     * @return 结果
     */
    public int updateEvaluate(Evaluate evaluate);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteEvaluateById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEvaluateByIds(Long[] ids);
}
