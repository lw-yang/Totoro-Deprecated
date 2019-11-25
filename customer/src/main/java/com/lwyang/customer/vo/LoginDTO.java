package com.lwyang.customer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录Json传输格式
 * @author lwyang  2019/11/21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class LoginDTO {

    @ApiModelProperty(value = "用户名", example = "lwyang", dataType = "String")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", example = "123456", dataType = "String")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
