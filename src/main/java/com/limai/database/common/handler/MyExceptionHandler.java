package com.limai.database.common.handler;

import com.limai.database.common.dto.ErrorInfo;
import com.limai.database.common.handler.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: zhangbin
 * @Date: 2018/11/5 10:09
 * @Desc:
 */
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorInfo userNotFound(UserNotFoundException e){
        String mobile = e.getMobile();
        return new ErrorInfo(4,"User ["+mobile+"] not Found");
    }
}
