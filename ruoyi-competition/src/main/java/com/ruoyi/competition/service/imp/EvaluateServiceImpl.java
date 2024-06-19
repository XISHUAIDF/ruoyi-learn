package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.EvaluateMapper;
import com.ruoyi.test.domain.Evaluate;
import com.ruoyi.test.service.IEvaluateService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author zjh
 * @date 2024-06-19
 */
@Service
public class EvaluateServiceImpl implements IEvaluateService 
{
    @Autowired
    private EvaluateMapper evaluateMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Evaluate selectEvaluateById(Long id)
    {
        return evaluateMapper.selectEvaluateById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param evaluate 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Evaluate> selectEvaluateList(Evaluate evaluate)
    {
        return evaluateMapper.selectEvaluateList(evaluate);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param evaluate 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertEvaluate(Evaluate evaluate)
    {
        return evaluateMapper.insertEvaluate(evaluate);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param evaluate 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateEvaluate(Evaluate evaluate)
    {
        return evaluateMapper.updateEvaluate(evaluate);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEvaluateByIds(Long[] ids)
    {
        return evaluateMapper.deleteEvaluateByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEvaluateById(Long id)
    {
        return evaluateMapper.deleteEvaluateById(id);
    }
}
