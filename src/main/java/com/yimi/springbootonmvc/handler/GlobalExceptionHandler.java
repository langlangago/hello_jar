package com.yimi.springbootonmvc.handler;

import com.yimi.springbootonmvc.exception.PageException;
import com.yimi.springbootonmvc.exception.ResponseBodyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 *
 * @author xiaozefeng
 * @date 2019-03-29 23:42
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     *  异常返回json   ResponseBodyException 和 除了PageException
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ResponseBodyException.class,Exception.class})
    @ResponseBody
    public Object handlerExceptionToJSON(HttpServletRequest request,
                                         Exception e) {
        log.error("error url: {}", request.getRequestURI());
        Map<String, Object> result = new HashMap<>();
        result.put("msg", e.getMessage());
        result.put("code", 500);
        result.put("data", null);
        return result;
    }


    /**
     * 异常返回页面
     * @param request
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(value = PageException.class)
    public String handlerExceptionToHTML(HttpServletRequest request,
                                         Model model,
                                         Exception e) {
        log.error("error url: {}", request.getRequestURI());
        model.addAttribute("msg", e.getMessage());
        model.addAttribute("code", 500);
        model.addAttribute("data", null);
        return "500";
    }

}
