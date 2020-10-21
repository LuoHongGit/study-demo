package cn.lh.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TestController {


    @RequestMapping("/index")
    public String velocityTest(Map map){
        map.put("message", "这是测试的内容。。。");
        map.put("toUserName", "张三1");
        map.put("fromUserName", "老许");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Map map){
        return "main";
    }




}