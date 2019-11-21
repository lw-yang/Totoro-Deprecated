package com.lwyang.customer.vo;

import com.lwyang.customer.annotation.ByteSupport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 用户信息修改Json传输格式
 * @author lwyang  2019/11/21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class CustomerEditVo {

    @ApiModelProperty(value = "邮箱", example = "1670906161@qq.com", dataType = "String")
    @Email(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty(value = "年龄", example = "23", dataType = "Integer")
    @Min(value = 1, message = "年龄应大于1")
    @Max(value = 100, message = "年龄应小于100")
    private Integer age;

    @ApiModelProperty(value = "性别", example = "1:男 / 2:女", dataType = "Integer")
    @ByteSupport(support = {"1","2"}, message = "性别输入错误")
    private Byte sex;
}
