package com.fuinha.springh2.web.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuinha.springh2.exception.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {
    @JsonIgnore
    private HttpStatus status = null;
    private T payload;
    private Error error;

    public BaseResponse(T payload) {
        if (Objects.isNull(payload)) {
            this.error = new Error(404, "No data was found");
            status = HttpStatus.NOT_FOUND;
        } else if (payload instanceof CustomException) {
            this.error = new Error(((CustomException) payload).getCode(), ((CustomException) payload).getMessage());
            status = ((CustomException) payload).getStatus();
        } else if (payload instanceof Exception) {
            this.error = new Error(500, ((Exception) payload).getClass().getName());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            this.payload = payload;
        }
    }

    public ResponseEntity<BaseResponse<T>> ok() {
        if (Objects.isNull(status))
            status = HttpStatus.OK;
        return new ResponseEntity<>(this, status);
    }

    public ResponseEntity<BaseResponse<T>> created() {
        if (Objects.isNull(status))
            status = HttpStatus.CREATED;
        return new ResponseEntity<>(this, status);
    }

    public ResponseEntity<BaseResponse<T>> error() {
        if (Objects.isNull(status))
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(this, status);
    }

    public ResponseEntity<BaseResponse<T>> deleted() {
        status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(this, status);
    }
}