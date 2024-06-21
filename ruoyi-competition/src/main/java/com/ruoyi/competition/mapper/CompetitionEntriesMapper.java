package com.ruoyi.competition.mapper;


import com.ruoyi.competition.domain.CompetitionEntries;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 参赛作品Mapper接口
 * 
 * @author zjh
 * @date 2024-06-18
 */


public interface CompetitionEntriesMapper 
{
    /**
     * 查询参赛作品
     * 
     * @param id 参赛作品主键
     * @return 参赛作品
     */
    public CompetitionEntries selectCompetitionEntriesById(Long id);

    /**
     * 查询参赛作品列表
     * 
     * @param competitionEntries 参赛作品
     * @return 参赛作品集合
     */
    public List<CompetitionEntries> selectCompetitionEntriesList(CompetitionEntries competitionEntries);

    /**
     * 新增参赛作品
     * 
     * @param competitionEntries 参赛作品
     * @return 结果
     */
    public int insertCompetitionEntries(CompetitionEntries competitionEntries);

    /**
     * 修改参赛作品
     * 
     * @param competitionEntries 参赛作品
     * @return 结果
     */
    public int updateCompetitionEntries(CompetitionEntries competitionEntries);

    /**
     * 删除参赛作品
     * 
     * @param id 参赛作品主键
     * @return 结果
     */
    public int deleteCompetitionEntriesById(Long id);

    /**
     * 批量删除参赛作品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompetitionEntriesByIds(Long[] ids);
}
