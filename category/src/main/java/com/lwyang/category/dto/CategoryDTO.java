package com.lwyang.category.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import converter.Long2StringSerialize;
import converter.String2LongDeserialize;
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
public class CategoryDTO {

    @JsonDeserialize(using = String2LongDeserialize.class)
    @JsonSerialize(using = Long2StringSerialize.class)
    private Long id;

    @NotEmpty(message = "请输入类别名称")
    private String name;

    @JsonDeserialize(using = String2LongDeserialize.class)
    @JsonSerialize(using = Long2StringSerialize.class)
    private Long parentId;

}
