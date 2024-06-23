package com.ruoyi.competition.service;


import com.ruoyi.competition.domain.Participants;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author zjh
 * @date 2024-06-18
 */
public interface IParticipantsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Participants selectParticipantsById(Long id);
    public Participants selectParticipantsByUsername(String username);
    /**
     * 查询【请填写功能名称】列表
     * 
     * @param participants 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Participants> selectParticipantsList(Participants participants);

    /**
     * 新增【请填写功能名称】
     * 
     * @param participants 【请填写功能名称】
     * @return 结果
     */
    public int insertParticipants(Participants participants);

    /**
     * 修改【请填写功能名称】
     * 
     * @param participants 【请填写功能名称】
     * @return 结果
     */
    public int updateParticipants(Participants participants);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteParticipantsByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteParticipantsById(Long id);

    public String importParticipants(List<Participants> participantsList, Boolean isUpdateSupport);
}
