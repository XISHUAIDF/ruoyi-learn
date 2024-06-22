package com.ruoyi.competition.vo;

import com.ruoyi.common.annotation.Excel;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class CompetitionShowVO {
    /** $column.columnComment */
    private Long id;
    @Excel(name = "作品图片")
    private String CoverPage;
    /** $column.columnComment */
    @Excel(name = "学校")
    private String school;

    /** $column.columnComment */
    @Excel(name = "作品名")
    private String name;

    /** $column.columnComment */
    @Excel(name = "参赛人名")
    private String participantName;

    /** $column.columnComment */
    @Excel(name = "联系方式")
    private String contactInfo;



    /** $column.columnComment */
    @Excel(name = "提交时间")
    private Date submissionTime;

    /** $column.columnComment */
    @Excel(name = "参赛组别")
    private String competitionGroup;

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
