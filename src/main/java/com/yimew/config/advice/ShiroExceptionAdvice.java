package com.yimew.config.advice;

import com.yimew.util.http.ResponseMessage;
import com.yimew.util.http.ResponseMessageCodeEnum;
import com.yimew.util.http.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(value=1)
public class ShiroExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ShiroExceptionAdvice.class);

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({AuthenticationException.class, UnknownAccountException.class,
            UnauthenticatedException.class, IncorrectCredentialsException.class})
    @ResponseBody
    public ResponseMessage unauthorized(Exception exception) {
        logger.warn(exception.getMessage(), exception);
        logger.info("catch UnknownAccountException");
        return Result.error(ResponseMessageCodeEnum.ERROR.getCode(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ResponseMessage unauthorized1(UnauthorizedException exception) {
        logger.warn(exception.getMessage(), exception);
        return Result.error(ResponseMessageCodeEnum.ERROR.getCode(), exception.getMessage());
    }
}
