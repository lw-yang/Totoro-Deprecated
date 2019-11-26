package com.lwyang.customer.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lwyang.customer.annotation.ByteSupport;
import converter.Long2StringSerialize;
import converter.String2LongDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.*;

/**
 * 用户信息修改Json传输格式
 * @author lwyang  2019/11/21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class EditCustomerDTO {

    @ApiModelProperty(value = "用户ID", example = "1", dataType = "String")
    @JsonDeserialize(using = String2LongDeserialize.class)
    @JsonSerialize(using = Long2StringSerialize.class)
    @NotNull(message = "请输入顾客Id")
    //TODO 前端Long类型会造成精度丢失，所以这里用String类型，但可以自定义Json转换器将String 转 Long
    private Long id;

    @ApiModelProperty(value = "邮箱", example = "1670906161@qq.com", dataType = "String")
    private String email;

    @ApiModelProperty(value = "年龄", example = "23", dataType = "Integer")
    @Min(value = 1, message = "年龄应大于1")
    @Max(value = 100, message = "年龄应小于100")
    private Integer age;

    @ApiModelProperty(value = "性别 1:男 / 2:女", example = "1", dataType = "Integer")
    @ByteSupport(support = {"1","2"}, message = "性别输入错误")
    private Byte sex;
}
