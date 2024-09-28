package com.example.App1.model;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 演示用的用户登录信息
 */
public class UserLoginInfo implements Serializable {

    private String userId;

    @NotEmpty(message = "名称不能为空")
    private String userName;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @NotEmpty(message = "密码不能为空")
    private String userPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
