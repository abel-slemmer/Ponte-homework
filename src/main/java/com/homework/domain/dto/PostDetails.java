package com.homework.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostDetails {


    @JsonProperty("channel_id")
    private String channeId;

    private String message;

    @JsonProperty("channel_id")
    public String getChanneId() {
        return channeId;
    }

    public PostDetails setChanneId(String channeId) {
        this.channeId = channeId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public PostDetails setMessage(String message) {
        this.message = message;
        return this;
    }
}
