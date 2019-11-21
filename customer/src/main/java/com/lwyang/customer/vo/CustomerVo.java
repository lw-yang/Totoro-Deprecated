package com.lwyang.customer.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerVo {

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
