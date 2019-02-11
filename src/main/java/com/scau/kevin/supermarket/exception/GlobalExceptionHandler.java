package com.scau.kevin.supermarket.exception;

import com.scau.kevin.supermarket.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: kevin
 * @Date: 2018/12/29 15:42
 * @Version 1.0
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value =  Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        if(e instanceof GlobalException){
            GlobalException ex = (GlobalException)e;
            return Result.error(ex.getCodeMessage());
        }else {
            e.printStackTrace();
            return Result.error(null);
        }

    }
}
