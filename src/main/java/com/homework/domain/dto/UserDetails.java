package com.homework.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {

    @JsonProperty("login_id")
    private String loginId;

    private String password;



    @JsonProperty("login_id")
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
        return "{" +
                "\"loginId\"=" + loginId + "\n"+
                "\"password\"=" + password +
                "}";
    }
}
