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

    @Excel(name = "密码")
    private String password;
    @Excel(name = "参赛团队")
    private String competitionGroup;
}
