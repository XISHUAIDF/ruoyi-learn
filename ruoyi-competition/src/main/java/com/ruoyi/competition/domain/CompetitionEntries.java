package com.ruoyi.competition.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 参赛作品对象 competition_entries
 * 
 * @author zjh
 * @date 2024-06-18
 */
public class CompetitionEntries extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;
    @Excel(name = "作品图片")
    private String CoverPage;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String school;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String participantName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String contactInfo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal averageScore;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date submissionTime;

    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String registerGroup;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String competitionGroup;


    @Excel(name = "信息公示")
    @NotBlank(message = "信息公示不能为空")
    private Long    informationDisclosure;

    /** 课堂实录 */
    @Excel(name = "课堂实录")
    @NotBlank(message = "课堂实录不能为空")
    private Long classRecordings;

    /** 教案 */
    @Excel(name = "教案")
    @NotBlank(message = "教案不能为空")
    private Long teachingPlans;

    /** 教学实施报告 */
    @Excel(name = "教学实施报告")
    @NotBlank(message = "教学实施报告不能为空")
    private Long teachingImplementationReport;

    /** 专业人才培养方案 */
    @Excel(name = "专业人才培养方案")
    @NotBlank(message = "专业人才培养方案不能为空")
    private Long professionalTrainingProgram;

    /** 课程标准 */
    @Excel(name = "课程标准")
    @NotBlank(message = "课程标准不能为空")
    private Long courseStandards;

    /** 教材选用说明 */
    @Excel(name = "教材选用说明")
    @NotBlank(message = "教材选用说明不能为空")
    private Long textbookSelection;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setParticipantName(String participantName) 
    {
        this.participantName = participantName;
    }

    public String getParticipantName() 
    {
        return participantName;
    }
    public void setContactInfo(String contactInfo) 
    {
        this.contactInfo = contactInfo;
    }

    public String getContactInfo() 
    {
        return contactInfo;
    }
    public void setAverageScore(BigDecimal averageScore) 
    {
        this.averageScore = averageScore;
    }

    public BigDecimal getAverageScore() 
    {
        return averageScore;
    }
    public void setSubmissionTime(Date submissionTime) 
    {
        this.submissionTime = submissionTime;
    }

    public Date getSubmissionTime() 
    {
        return submissionTime;
    }
    public void setCompetitionGroup(String competitionGroup) 
    {
        this.competitionGroup = competitionGroup;
    }

    public String getCompetitionGroup() 
    {
        return competitionGroup;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("school", getSchool())
            .append("name", getName())
            .append("participantName", getParticipantName())
            .append("contactInfo", getContactInfo())
            .append("averageScore", getAverageScore())
            .append("submissionTime", getSubmissionTime())
            .append("competitionGroup", getCompetitionGroup())
            .toString();
    }
}
