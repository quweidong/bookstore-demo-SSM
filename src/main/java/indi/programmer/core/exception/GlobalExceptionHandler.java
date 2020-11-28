package indi.programmer.core.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**全局处理异常类*/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**处理所有的异常，跳转到错误页面*/
    @ExceptionHandler(value = Exception.class)
    public void doAllException(Exception exception){
        /*打印异常的堆栈信息*/
        exception.printStackTrace();
    }
}
