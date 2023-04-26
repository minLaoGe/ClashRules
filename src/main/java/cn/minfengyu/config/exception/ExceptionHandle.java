package cn.minfengyu.config.exception;

import cn.minfengyu.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author wjl
 * @date
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = BindException.class)
    public BaseResult bingEx(BindException e) {
        log.error("参数校验异常：{}", e.getMessage());
        return BaseResult.getFail(e.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public BaseResult paramsEx(IllegalArgumentException e) {
        log.error("参数校验异常：{}", e.getMessage());
        return BaseResult.getFail(e.getMessage());
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResult paramsBindEx(MethodArgumentNotValidException e) {
        log.error("参数校验异常：{}", e.getMessage());
        return BaseResult.getFail(e.getBindingResult().getFieldError().getDefaultMessage());
    }




    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public BaseResult requestError(HttpRequestMethodNotSupportedException e) {
        log.error("请求方式错误：{}", e.getMessage());
        return BaseResult.getFail(e.getMessage());
    }

    @ExceptionHandler(value = ServiceException.class)
    public BaseResult serviceEx(ServiceException e) {
        log.error("ServiceException: {}", e.getMessage(), e);
        return BaseResult.getFail(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(value = Exception.class)
    public BaseResult handle(Exception ex) {
        log.error("Exception", ex.getMessage(), ex);
        return BaseResult.getFail();
    }

}
