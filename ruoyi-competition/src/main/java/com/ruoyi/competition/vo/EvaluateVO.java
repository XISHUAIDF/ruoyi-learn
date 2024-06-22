package com.ruoyi.competition.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class EvaluateVO {
    private Long id;
    /** 学校 */
    @Excel(name = "学校", readConverterExp = "$column.readConverterExp()")
    private String school;

    /** 名称 */
    @Excel(name = "名称", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** 参与者姓名 */
    @Excel(name = "参与者姓名", readConverterExp = "$column.readConverterExp()")
    private String participantName;

    /** 联系方式 */
    @Excel(name = "联系方式", readConverterExp = "$column.readConverterExp()")
    private String contactInfo;

    /** 平均分数 */
    @Excel(name = "平均分数", readConverterExp = "$column.readConverterExp()")
    private BigDecimal averageScore;

    /** 提交时间 */
    @Excel(name = "提交时间", readConverterExp = "$column.readConverterExp()")
    private Date submissionTime;

    /** 注册组 */
    @Excel(name = "注册组", readConverterExp = "$column.readConverterExp()")
    private String registerGroup;

}
