package com.yimi.springbootonmvc.exception;

/**
 * @author xiaozefeng
 * @date 2019-03-29 23:49
 */
public class ResponseBodyException extends RuntimeException {
    public ResponseBodyException(String message) {
        super(message);
    }
}
