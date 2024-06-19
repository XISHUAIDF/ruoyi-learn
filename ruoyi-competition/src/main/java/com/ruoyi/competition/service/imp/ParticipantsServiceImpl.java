package com.ruoyi.competition.service.imp;

import com.ruoyi.competition.domain.Participants;
import com.ruoyi.competition.mapper.ParticipantsMapper;
import com.ruoyi.competition.service.IParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author zjh
 * @date 2024-06-18
 */
@Service
public class ParticipantsServiceImpl implements IParticipantsService
{
    @Autowired
    private ParticipantsMapper participantsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Participants selectParticipantsById(Long id)
    {
        return participantsMapper.selectParticipantsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param participants 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Participants> selectParticipantsList(Participants participants)
    {
        return participantsMapper.selectParticipantsList(participants);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param participants 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertParticipants(Participants participants)
    {
        return participantsMapper.insertParticipants(participants);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param participants 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateParticipants(Participants participants)
    {
        return participantsMapper.updateParticipants(participants);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteParticipantsByIds(Long[] ids)
    {
        return participantsMapper.deleteParticipantsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteParticipantsById(Long id)
    {
        return participantsMapper.deleteParticipantsById(id);
    }
}
