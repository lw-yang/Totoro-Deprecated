package com.lwyang.category.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import converter.Long2StringSerialize;
import converter.String2LongDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lwyang  2019/11/26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditCategoryDTO {

    @JsonDeserialize(using = String2LongDeserialize.class)
    @JsonSerialize(using = Long2StringSerialize.class)
    @NotNull(message = "请输入类别Id")
    private Long id;

    private String name;

    private String src;

    private Integer priority;

    @JsonDeserialize(using = String2LongDeserialize.class)
    @JsonSerialize(using = Long2StringSerialize.class)
    private Long parentId;


}
