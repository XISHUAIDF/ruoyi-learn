package com.ruoyi.competition.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * 参赛团队对象 participants
 *
 * @author zjh
 * @date 2024-06-18
 */
@Data
public class Participants extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 身份 */
    @Excel(name = "身份")
    @NotBlank(message = "身份不能为空")
    private String identity;

    /** 学校 */
    @Excel(name = "学校")
    @NotBlank(message = "学校不能为空")
    private String school;

    /** 名称 */
    @Excel(name = "名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    /** 注册组 */
    @Excel(name = "注册组")
    @NotBlank(message = "注册组不能为空")
    private String registrationGroup;

    /** 用户名 */
    @Excel(name = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /** 创建时间 */
    @Excel(name = "创建时间", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    /** 信息公示 */
    @Excel(name = "信息公示")
    @NotBlank(message = "信息公示不能为空")
    private String informationDisclosure;

    /** 课堂实录 */
    @Excel(name = "课堂实录")
    @NotBlank(message = "课堂实录不能为空")
    private String classRecordings;

    /** 教案 */
    @Excel(name = "教案")
    @NotBlank(message = "教案不能为空")
    private String teachingPlans;

    /** 教学实施报告 */
    @Excel(name = "教学实施报告")
    @NotBlank(message = "教学实施报告不能为空")
    private String teachingImplementationReport;

    /** 专业人才培养方案 */
    @Excel(name = "专业人才培养方案")
    @NotBlank(message = "专业人才培养方案不能为空")
    private String professionalTrainingProgram;

    /** 课程标准 */
    @Excel(name = "课程标准")
    @NotBlank(message = "课程标准不能为空")
    private String courseStandards;

    /** 教材选用说明 */
    @Excel(name = "教材选用说明")
    @NotBlank(message = "教材选用说明不能为空")
    private String textbookSelection;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setIdentity(String identity)
    {
        this.identity = identity;
    }

    public String getIdentity()
    {
        return identity;
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
    public void setRegistrationGroup(String registrationGroup)
    {
        this.registrationGroup = registrationGroup;
    }

    public String getRegistrationGroup()
    {
        return registrationGroup;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setInformationDisclosure(String informationDisclosure)
    {
        this.informationDisclosure = informationDisclosure;
    }

    public String getInformationDisclosure()
    {
        return informationDisclosure;
    }

    public void setClassRecordings(String classRecordings)
    {
        this.classRecordings = classRecordings;
    }

    public String getClassRecordings()
    {
        return classRecordings;
    }

    public void setTeachingPlans(String teachingPlans)
    {
        this.teachingPlans = teachingPlans;
    }

    public String getTeachingPlans()
    {
        return teachingPlans;
    }

    public void setTeachingImplementationReport(String teachingImplementationReport)
    {
        this.teachingImplementationReport = teachingImplementationReport;
    }

    public String getTeachingImplementationReport()
    {
        return teachingImplementationReport;
    }

    public void setProfessionalTrainingProgram(String professionalTrainingProgram)
    {
        this.professionalTrainingProgram = professionalTrainingProgram;
    }

    public String getProfessionalTrainingProgram()
    {
        return professionalTrainingProgram;
    }

    public void setCourseStandards(String courseStandards)
    {
        this.courseStandards = courseStandards;
    }

    public String getCourseStandards()
    {
        return courseStandards;
    }

    public void setTextbookSelection(String textbookSelection)
    {
        this.textbookSelection = textbookSelection;
    }

    public String getTextbookSelection()
    {
        return textbookSelection;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("identity", getIdentity())
                .append("school", getSchool())
                .append("name", getName())
                .append("registrationGroup", getRegistrationGroup())
                .append("username", getUsername())
                .append("createdAt", getCreatedAt())
                .append("informationDisclosure", getInformationDisclosure())
                .append("classRecordings", getClassRecordings())
                .append("teachingPlans", getTeachingPlans())
                .append("teachingImplementationReport", getTeachingImplementationReport())
                .append("professionalTrainingProgram", getProfessionalTrainingProgram())
                .append("courseStandards", getCourseStandards())
                .append("textbookSelection", getTextbookSelection())
                .toString();
    }
}
