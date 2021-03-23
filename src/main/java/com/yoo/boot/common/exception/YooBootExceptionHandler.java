package com.yoo.boot.common.exception;

import com.yoo.boot.common.api.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class YooBootExceptionHandler {
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(YooBootException.class)
    public Result<?> handleRRException(YooBootException e){
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }
}
