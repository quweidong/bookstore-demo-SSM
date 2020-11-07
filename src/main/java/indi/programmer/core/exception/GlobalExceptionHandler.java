package indi.programmer.core.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**全局处理异常类*/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**所有的异常在这里进行输出*/
    @ExceptionHandler(value = Exception.class)
    public void doAllException(Exception exception){
        exception.printStackTrace();
    }
}
