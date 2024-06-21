package com.ruoyi.competition.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class CompetitionEntriesVO { /** $column.columnComment */
private Long id;

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
    @Excel(name = "平均分")
    private BigDecimal averageScore;

    /** $column.columnComment */
    @Excel(name = "提交时间")
    private Date submissionTime;

    /** $column.columnComment */
    @Excel(name = "参赛组别")
    private String competitionGroup;
}
