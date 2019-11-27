package com.lwyang.category.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lwyang.common.converter.Long2StringSerialize;
import com.lwyang.common.converter.String2LongDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * category传输实体
 * @author lwyang  2019/11/25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class CategoryDTO {

    @JsonDeserialize(using = String2LongDeserialize.class)
    @JsonSerialize(using = Long2StringSerialize.class)
    //TODO 前端Long类型会造成精度丢失，所以这里用String类型，但可以自定义Json转换器将String 转 Long
    private Long id;

    @ApiModelProperty(value = "类别名称", example = "类别")
    @NotEmpty(message = "请输入类别名称")
    private String name;

    private String src;

    private Integer priority;

    @JsonDeserialize(using = String2LongDeserialize.class)
    @JsonSerialize(using = Long2StringSerialize.class)
    @ApiModelProperty(value = "父级类别ID")
    private Long parentId;

}
