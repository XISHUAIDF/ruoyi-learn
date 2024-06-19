package com.ruoyi.competition.service.imp;


import com.ruoyi.competition.domain.CompetitionEntries;
import com.ruoyi.competition.mapper.CompetitionEntriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.competitionEntry.service.ICompetitionEntriesService;

import java.util.List;

/**
 * 参赛作品Service业务层处理
 * 
 * @author zjh
 * @date 2024-06-18
 */
@Service
public class CompetitionEntriesServiceImpl implements ICompetitionEntriesService 
{
    @Autowired
    private CompetitionEntriesMapper competitionEntriesMapper;

    /**
     * 查询参赛作品
     * 
     * @param id 参赛作品主键
     * @return 参赛作品
     */
    @Override
    public CompetitionEntries selectCompetitionEntriesById(Long id)
    {
        return competitionEntriesMapper.selectCompetitionEntriesById(id);
    }

    /**
     * 查询参赛作品列表
     * 
     * @param competitionEntries 参赛作品
     * @return 参赛作品
     */
    @Override
    public List<CompetitionEntries> selectCompetitionEntriesList(CompetitionEntries competitionEntries)
    {
        return competitionEntriesMapper.selectCompetitionEntriesList(competitionEntries);
    }

    /**
     * 新增参赛作品
     * 
     * @param competitionEntries 参赛作品
     * @return 结果
     */
    @Override
    public int insertCompetitionEntries(CompetitionEntries competitionEntries)
    {
        return competitionEntriesMapper.insertCompetitionEntries(competitionEntries);
    }

    /**
     * 修改参赛作品
     * 
     * @param competitionEntries 参赛作品
     * @return 结果
     */
    @Override
    public int updateCompetitionEntries(CompetitionEntries competitionEntries)
    {
        return competitionEntriesMapper.updateCompetitionEntries(competitionEntries);
    }

    /**
     * 批量删除参赛作品
     * 
     * @param ids 需要删除的参赛作品主键
     * @return 结果
     */
    @Override
    public int deleteCompetitionEntriesByIds(Long[] ids)
    {
        return competitionEntriesMapper.deleteCompetitionEntriesByIds(ids);
    }

    /**
     * 删除参赛作品信息
     * 
     * @param id 参赛作品主键
     * @return 结果
     */
    @Override
    public int deleteCompetitionEntriesById(Long id)
    {
        return competitionEntriesMapper.deleteCompetitionEntriesById(id);
    }
}
