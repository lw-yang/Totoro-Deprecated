package com.lwyang.customer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
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
@ApiModel
public class CustomerVo {

    private Long id;

    @ApiModelProperty(value = "用户名", example = "lwyang", dataType = "String")
    private String username;

    @ApiModelProperty(value = "密码", example = "123456", dataType = "String")
    private String password;

    @ApiModelProperty(value = "密保问题", example = "问题", dataType = "String")
    private String question;

    @ApiModelProperty(value = "密保答案", example = "答案", dataType = "String")
    private String answer;

    @ApiModelProperty(value = "用户头像", example = "https://img.yzcdn.cn/vant/cat.jpeg", dataType = "String")
    private String avatar;

    @ApiModelProperty(value = "邮箱", example = "1670906161@qq.com", dataType = "String")
    private String email;

    @ApiModelProperty(value = "年龄", example = "23", dataType = "Integer")
    private Integer age;

    @ApiModelProperty(value = "性别", example = "1:男 / 2:女", dataType = "Integer")
    private Byte sex;

    @ApiModelProperty(value = "积分", example = "0", dataType = "Integer")
    private Integer points;

    @ApiModelProperty(value = "用户状态", example = "0:禁用 / 1:正常", dataType = "Integer")
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

    public boolean validateUpdate(){
        if (StringUtils.isEmpty(username)){
            return false;
        }
        if (StringUtils.isAllEmpty(email,String.valueOf(age),String.valueOf(sex))){
            return false;
        }
        return true;
    }
}
