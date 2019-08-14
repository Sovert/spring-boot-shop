package com.qch.shop.exception;

import com.qch.shop.entity.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice({"com.qch.shop.controller"})
public class ExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        if(errors.size() == 0 || errors.get(0) == null) {
            return Result.error("字段验证错误");
        }
        return Result.error(errors.get(0).getDefaultMessage());
    }
}
