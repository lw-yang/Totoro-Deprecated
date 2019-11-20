package com.lwyang.customer.vo;

import com.lwyang.customer.annotation.Byte;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterVo {

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

    @ApiModelProperty(value = "邮箱", example = "1670906161@qq.com", dataType = "String")
    @Email(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty(value = "年龄", example = "23", dataType = "Integer")
    @Min(value = 1, message = "年龄应大于1")
    @Max(value = 100, message = "年龄应小于100")
    private Integer age;

    @ApiModelProperty(value = "性别", example = "1:男 / 2:女", dataType = "Integer")
    @Byte(support = {"1","2"}, message = "性别输入错误")
    private java.lang.Byte sex;
}
