package com.ruoyi.competition.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 【请填写功能名称】对象 evaluate
 * 
 * @author zjh
 * @date 2024-06-19
 */
public class Evaluate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "序号")
    private Long id;

    /** $column.columnComment */
    @Excel(name = "学校")
    private String school;

    /** $column.columnComment */
    @Excel(name = "作品名")
    private String workName;

    /** $column.columnComment */
    @Excel(name = "评委姓名")
    private String judgeName;

    /** $column.columnComment */
    @Excel(name = "教学实施")
    private BigDecimal teachingImplementation;

    /** $column.columnComment */
    @Excel(name = "课堂教案")
    private BigDecimal lessonPlan;

    /** $column.columnComment */
    @Excel(name = "视频资料")
    private BigDecimal videoMaterials;

    /** $column.columnComment */
    @Excel(name = "专业培训计划")
    private BigDecimal professionalTrainingPlan;

    /** $column.columnComment */
    @Excel(name = "课程标准")
    private BigDecimal courseStandard;

    /** $column.columnComment */
    @Excel(name = "教材选用")
    private BigDecimal textbookSelection;

    /** $column.columnComment */
    @Excel(name = "得分")
    private BigDecimal score;

    /** $column.columnComment */
    @Excel(name = "评价时间")
    private Date evaluationTime;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
    }
    public void setWorkName(String workName) 
    {
        this.workName = workName;
    }

    public String getWorkName() 
    {
        return workName;
    }
    public void setJudgeName(String judgeName) 
    {
        this.judgeName = judgeName;
    }

    public String getJudgeName() 
    {
        return judgeName;
    }
    public void setTeachingImplementation(BigDecimal teachingImplementation) 
    {
        this.teachingImplementation = teachingImplementation;
    }

    public BigDecimal getTeachingImplementation() 
    {
        return teachingImplementation;
    }
    public void setLessonPlan(BigDecimal lessonPlan) 
    {
        this.lessonPlan = lessonPlan;
    }

    public BigDecimal getLessonPlan() 
    {
        return lessonPlan;
    }
    public void setVideoMaterials(BigDecimal videoMaterials) 
    {
        this.videoMaterials = videoMaterials;
    }

    public BigDecimal getVideoMaterials() 
    {
        return videoMaterials;
    }
    public void setProfessionalTrainingPlan(BigDecimal professionalTrainingPlan) 
    {
        this.professionalTrainingPlan = professionalTrainingPlan;
    }

    public BigDecimal getProfessionalTrainingPlan() 
    {
        return professionalTrainingPlan;
    }
    public void setCourseStandard(BigDecimal courseStandard) 
    {
        this.courseStandard = courseStandard;
    }

    public BigDecimal getCourseStandard() 
    {
        return courseStandard;
    }
    public void setTextbookSelection(BigDecimal textbookSelection) 
    {
        this.textbookSelection = textbookSelection;
    }

    public BigDecimal getTextbookSelection() 
    {
        return textbookSelection;
    }
    public void setScore(BigDecimal score) 
    {
        this.score = score;
    }

    public BigDecimal getScore() 
    {
        return score;
    }
    public void setEvaluationTime(Date evaluationTime) 
    {
        this.evaluationTime = evaluationTime;
    }

    public Date getEvaluationTime() 
    {
        return evaluationTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("school", getSchool())
            .append("workName", getWorkName())
            .append("judgeName", getJudgeName())
            .append("teachingImplementation", getTeachingImplementation())
            .append("lessonPlan", getLessonPlan())
            .append("videoMaterials", getVideoMaterials())
            .append("professionalTrainingPlan", getProfessionalTrainingPlan())
            .append("courseStandard", getCourseStandard())
            .append("textbookSelection", getTextbookSelection())
            .append("score", getScore())
            .append("evaluationTime", getEvaluationTime())
            .toString();
    }
}
