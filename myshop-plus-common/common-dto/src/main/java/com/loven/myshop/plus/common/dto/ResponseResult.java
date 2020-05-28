package com.loven.myshop.plus.common.dto;


import com.loven.myshop.plus.common.constant.CodeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 通用响应类.
 *
 * @author loven.
 * @date 2020/5/20.
 */
@Data
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 7002399937134372853L;

    private int code;
    private T data;
    private Cursor cursor;
    private String message;

    @Data
    @AllArgsConstructor
    public static class Cursor{
        private int total;
        private int offset;
        private int limit;
    }

    private static <T> ResponseResult<T> getBaseResult(int code, T data, Cursor cursor, String message) {
        ResponseResult<T> baseResult = new ResponseResult<>();
        baseResult.code = code;
        baseResult.data = data;
        baseResult.cursor = cursor;
        baseResult.message = message;
        return baseResult;
    }

    public static <T> ResponseResult<T> success(){
        return getBaseResult(CodeStatus.OK, null, null, null);
    }

    public static <T> ResponseResult<T> success(T data){
        return getBaseResult(CodeStatus.OK, data, null, null);
    }

    public static <T> ResponseResult<T> success(T data, Cursor cursor){
        return getBaseResult(CodeStatus.OK, data, cursor, null);
    }

    public static <T> ResponseResult<T> success(T data, String msg){
        return getBaseResult(CodeStatus.OK, data, null, msg);
    }

    public static <T> ResponseResult<T> success(String msg){
        return getBaseResult(CodeStatus.OK, null, null, msg);
    }

    public static <T> ResponseResult<T> fail(int code, String message){
        return getBaseResult(code,null, null, message);
    }

}


