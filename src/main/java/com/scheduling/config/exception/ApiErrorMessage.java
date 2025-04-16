package com.scheduling.config.exception;

import org.springframework.http.HttpStatusCode;

import java.util.Arrays;
import java.util.List;

public class ApiErrorMessage {

    private HttpStatusCode status;
    private Integer code;
    private List<String> errors;

    public ApiErrorMessage(HttpStatusCode status, Integer code, List<String> errors) {
        super();
        this.status = status;
        this.code = code;
        this.errors = errors;
    }

    public ApiErrorMessage(HttpStatusCode status, Integer code, String error) {
        super();
        this.status = status;
        this.code = code;
        this.errors = Arrays.asList(error);
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
