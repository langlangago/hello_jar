package com.yimi.springbootonmvc.exception;

/**
 * @author xiaozefeng
 * @date 2019-03-29 23:49
 */
public class PageException extends RuntimeException{
    public PageException(String msg) {
        super(msg);
    }
}
