package com.ruoyi.competition.mapper;

import com.ruoyi.competition.domain.Articlereviews;

import java.util.List;

/**
 * 作品评价Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-21
 */
public interface ArticlereviewsMapper 
{
    /**
     * 查询作品评价
     * 
     * @param id 作品评价主键
     * @return 作品评价
     */
    public Articlereviews selectArticlereviewsById(Long id);

    /**
     * 查询作品评价列表
     * 
     * @param articlereviews 作品评价
     * @return 作品评价集合
     */
    public List<Articlereviews> selectArticlereviewsList(Articlereviews articlereviews);

    /**
     * 新增作品评价
     * 
     * @param articlereviews 作品评价
     * @return 结果
     */
    public int insertArticlereviews(Articlereviews articlereviews);

    /**
     * 修改作品评价
     * 
     * @param articlereviews 作品评价
     * @return 结果
     */
    public int updateArticlereviews(Articlereviews articlereviews);

    /**
     * 删除作品评价
     * 
     * @param id 作品评价主键
     * @return 结果
     */
    public int deleteArticlereviewsById(Long id);

    /**
     * 批量删除作品评价
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticlereviewsByIds(Long[] ids);
}
