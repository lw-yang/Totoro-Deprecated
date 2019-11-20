package com.lwyang.customer.vo;

import com.lwyang.customer.annotation.Byte;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class CustomerVo {

    private Long id;

    @ApiModelProperty(value = "用户名", example = "lwyang", dataType = "String")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", example = "123456", dataType = "String")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "密保问题", example = "问题", dataType = "String")
    @NotEmpty(message = "密保问题不能为空")
    private String question;

    @ApiModelProperty(value = "密保答案", example = "答案", dataType = "String")
    @NotEmpty(message = "密保答案不能为空")
    private String answer;

    @ApiModelProperty(value = "用户头像", example = "https://img.yzcdn.cn/vant/cat.jpeg", dataType = "String")
    private String avatar;

    @ApiModelProperty(value = "邮箱", example = "1670906161@qq.com", dataType = "String")
    @Email(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty(value = "年龄", example = "23", dataType = "Integer")
    @Min(value = 1, message = "年龄应大于1")
    @Max(value = 100, message = "年龄应小于100")
    private Integer age;

    @ApiModelProperty(value = "性别", example = "1:男 / 2:女", dataType = "Integer")
    @Byte(support = {"1","2"}, message = "性别输入错误")
    private Byte sex;

    @ApiModelProperty(value = "积分", example = "0", dataType = "Integer")
    private Integer points;

    @ApiModelProperty(value = "用户状态", example = "0:禁用 / 1:正常", dataType = "Integer")
    private Byte status;

    private LocalDateTime loginTime;

    private String loginIp;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
