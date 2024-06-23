package com.ruoyi.competition.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class ParticipantsVO {
    private String id;
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
    @Excel(name = "注册组")
    @NotBlank(message = "注册组不能为空")
    private String registrationGroup;

    /** 用户名 */
    @Excel(name = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @Excel(name = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}
