package com.fuinha.springh2.web.dto;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> implements Serializable {
    private T payload;
    private Error error;

    public BaseResponse(T payload) {
        if (Objects.isNull(payload))
            this.error = new Error(404, "No data was found");
        else if (payload instanceof Exception)
            this.error = new Error(500, ((Exception) payload).getMessage());
    }
    
}