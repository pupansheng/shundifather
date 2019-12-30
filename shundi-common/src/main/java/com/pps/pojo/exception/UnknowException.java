package com.pps.pojo.exception;

/**
 * @Classname UnknowException
 * @Description
 * @@Author Pupansheng
 * @Date 2019/12/21 15:17
 * @Vestion 1.0
 **/
public class UnknowException extends  RuntimeException {
    public UnknowException() {
        super();
    }

    public UnknowException(String message) {
        super(message);
    }
}
