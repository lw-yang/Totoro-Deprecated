package com.lwyang.category.dto;

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
    private Long id;

    @NotEmpty(message = "请输入类别名称")
    private String name;

    private Long parentId;

}
