package com.loven.myshop.plus.common.consumer.utils;

import com.google.common.collect.Lists;
import com.loven.myshop.plus.common.dto.ResponseResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * validate 处理类
 *
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/21.
 */
public class ValidateUtils {

    public static String getErrors(Errors errors){
        List<ObjectError> oes = errors.getAllErrors();
        if(oes.size() == 0){
            return null;
        }
        String error = "";
        for (ObjectError oe : oes) {
            String field = null;
            String msg = null;
            // 字段错误
            if (oe instanceof FieldError) {
                FieldError fe = (FieldError) oe;
                // 获取错误验证字段名
                field = fe.getField();
            }

            // 非字段错误
            else {
                // 获取验证对象名称
                field = oe.getObjectName();
            }
            msg = oe.getDefaultMessage();
            error = field + ": " + msg;
        }
        return error;
    }
}
