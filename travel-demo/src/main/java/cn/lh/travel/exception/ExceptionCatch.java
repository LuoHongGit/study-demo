package cn.lh.travel.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常捕获类
 * @author Administrator
 * @version 1.0
 * @create 2020-10-23 17:32
 **/
//控制器增强
@ControllerAdvice
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //捕获Exception此类异常
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception exception){
        //记录日志
        LOGGER.error("catch exception:{}",exception.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mistake");
        mv.addObject("exception", exception);

        return mv;
    }

}
