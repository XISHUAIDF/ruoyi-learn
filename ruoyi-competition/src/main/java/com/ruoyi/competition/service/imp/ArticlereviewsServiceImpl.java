package com.ruoyi.competition.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.competition.mapper.ArticlereviewsMapper;
import com.ruoyi.competition.domain.Articlereviews;
import com.ruoyi.competition.service.IArticlereviewsService;

/**
 * 作品评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-21
 */
@Service
public class ArticlereviewsServiceImpl implements IArticlereviewsService 
{
    @Autowired
    private ArticlereviewsMapper articlereviewsMapper;

    /**
     * 查询作品评价
     * 
     * @param id 作品评价主键
     * @return 作品评价
     */
    @Override
    public Articlereviews selectArticlereviewsById(Long id)
    {
        return articlereviewsMapper.selectArticlereviewsById(id);
    }

    /**
     * 查询作品评价列表
     * 
     * @param articlereviews 作品评价
     * @return 作品评价
     */
    @Override
    public List<Articlereviews> selectArticlereviewsList(Articlereviews articlereviews)
    {
        return articlereviewsMapper.selectArticlereviewsList(articlereviews);
    }

    /**
     * 新增作品评价
     * 
     * @param articlereviews 作品评价
     * @return 结果
     */
    @Override
    public int insertArticlereviews(Articlereviews articlereviews)
    {
        return articlereviewsMapper.insertArticlereviews(articlereviews);
    }

    /**
     * 修改作品评价
     * 
     * @param articlereviews 作品评价
     * @return 结果
     */
    @Override
    public int updateArticlereviews(Articlereviews articlereviews)
    {
        return articlereviewsMapper.updateArticlereviews(articlereviews);
    }

    /**
     * 批量删除作品评价
     * 
     * @param ids 需要删除的作品评价主键
     * @return 结果
     */
    @Override
    public int deleteArticlereviewsByIds(Long[] ids)
    {
        return articlereviewsMapper.deleteArticlereviewsByIds(ids);
    }

    /**
     * 删除作品评价信息
     * 
     * @param id 作品评价主键
     * @return 结果
     */
    @Override
    public int deleteArticlereviewsById(Long id)
    {
        return articlereviewsMapper.deleteArticlereviewsById(id);
    }
}
