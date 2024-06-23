package com.ruoyi.competition.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 作品评价对象 articlereviews
 * 
 * @author ruoyi
 * @date 2024-06-21
 */
public class Articlereviews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 参与者ID */
    @Excel(name = "参与者ID")
    private Long participantId;

    @Excel(name = "评价ID")
    private Long evaluateId;

    /** 评论人 */
    @Excel(name = "评论人")
    private String reviewer;

    /** 分数 */
    @Excel(name = "分数")
    private BigDecimal score;

    /** 评论 */
    @Excel(name = "评论")
    private String reviewComments;

    /** 创建时间 */
    @Excel(name = "创建时间", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    /** 更新时间 */
    @Excel(name = "更新时间", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setParticipantId(Long participantId) 
    {
        this.participantId = participantId;
    }

    public Long getParticipantId() 
    {
        return participantId;
    }
    public void setReviewer(String reviewer) 
    {
        this.reviewer = reviewer;
    }

    public String getReviewer() 
    {
        return reviewer;
    }
    public void setScore(BigDecimal score) 
    {
        this.score = score;
    }

    public BigDecimal getScore() 
    {
        return score;
    }
    public void setReviewComments(String reviewComments) 
    {
        this.reviewComments = reviewComments;
    }

    public String getReviewComments() 
    {
        return reviewComments;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("participantId", getParticipantId())
            .append("reviewer", getReviewer())
            .append("score", getScore())
            .append("reviewComments", getReviewComments())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .append("status", getStatus())
            .toString();
    }
}
