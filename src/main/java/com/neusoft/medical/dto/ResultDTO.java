package com.neusoft.medical.dto;

/**
 * 提供给 request.js 的 data
 *
 * @param <T>被封装的数据类型
 */
public class ResultDTO<T> {

    /**
     * 20000: success
     * 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
     */

    public static final int CODE_SUCCESS = 20000;
    public static final int CODE_ILLEGAL_TOKEN = 50008;
    public static final int CODE_OTHER_CLIENTS_LOGGED_IN = 50012;
    public static final int CODE_TOKEN_EXPIRED = 50014;

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public ResultDTO(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultDTO(T data) {
        code = CODE_SUCCESS;  // 正常返回结果
        this.data = data;
    }

    public ResultDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
