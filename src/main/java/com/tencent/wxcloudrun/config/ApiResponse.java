package com.tencent.wxcloudrun.config;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private Integer code;
    private String message;
    private T data; 

    public static <T> ApiResponse<T> ok() {
        return ok(null);
    }

    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(0);
        response.setMessage("success");
        response.setData(data);
        return response;
    }

    public static <T> ApiResponse<T> error(String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(1);
        response.setMessage(message);
        return response;
    }
}
