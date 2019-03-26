package com.homework.domain.dto;


public class UserDetails {

    private String loginId;
    private String password;

    public UserDetails(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public UserDetails() {
    }

    public String getLoginId() {
        return loginId;
    }

    public UserDetails setLoginId(String loginId) {
        this.loginId = loginId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDetails setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
