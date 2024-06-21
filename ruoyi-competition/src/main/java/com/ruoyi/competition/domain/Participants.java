package com.ruoyi.competition.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

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

}
