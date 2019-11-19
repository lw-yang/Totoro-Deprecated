package com.lwyang.customer.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerVo {

    private Long id;

    private String username;

    private String password;

    private String answer;

    private String question;

    private String avatar;

    private String email;

    private Integer age;

    private Byte sex;

    private Integer points;

    private Byte status;

    private LocalDateTime loginTime;

    private String loginIp;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public boolean validateRegistration(){
        if (StringUtils.isAnyEmpty(username,password,question,answer,email)){
            return false;
        }
        return true;
    }

    public boolean validateLogin(){
        if (StringUtils.isAnyEmpty(username, password)){
            return false;
        }
        return true;
    }
}
