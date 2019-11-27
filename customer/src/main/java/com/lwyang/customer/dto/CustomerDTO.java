package com.lwyang.customer.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lwyang.common.converter.Long2StringSerialize;
import com.lwyang.common.converter.String2LongDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

    @JsonDeserialize(using = String2LongDeserialize.class)
    @JsonSerialize(using = Long2StringSerialize.class)
    private Long id;

    private String username;

    private String avatar;

    private String email;

    private Integer age;

    private Byte sex;

    private Integer points;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
