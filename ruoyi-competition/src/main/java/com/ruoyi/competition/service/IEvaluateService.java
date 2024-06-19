package com.ruoyi.test.service;

import java.util.List;
import com.ruoyi.test.domain.Evaluate;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author zjh
 * @date 2024-06-19
 */
public interface IEvaluateService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteEvaluateByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteEvaluateById(Long id);
}
