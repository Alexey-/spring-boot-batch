package com.sebbia.batch.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Response {

    private int code;

    public Response(int code) {
        this.code = code;
	}

    @JsonProperty
    public int getCode() {
        return code;
    }

}
