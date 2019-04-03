package com.yimi.springbootonmvc.controller;

import com.yimi.springbootonmvc.exception.PageException;
import com.yimi.springbootonmvc.exception.ResponseBodyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaozefeng
 * @date 2019-03-29 23:55
 */
@RestController
public class IndexController {


    @GetMapping("/npe")
    public String npe(){
        int a = 1;
        int b = 0;
        int c = a / b;
        return "ok";
    }

    @GetMapping("page/exception")
    public String pageException() {
        throw new PageException("页面错误测试");
    }

    @GetMapping("responseBody/exception")
    public String responseBodyException(){
        throw new ResponseBodyException("json错误测试");
    }
}
