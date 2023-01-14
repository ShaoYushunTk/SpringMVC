package org.example.controller;

import org.example.exception.BusinessException;
import org.example.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器和自定义的异常结合使用
 * @RestControllerAdvice 用于标识当前类为REST风格对应的异常处理器
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException exception){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(exception.getCode(),null, exception.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException exception){
        return new Result(exception.getCode(),null, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(Code.SYSTEM_UNKNOWN_ERR,null,"Exception: " + exception);
    }
}
