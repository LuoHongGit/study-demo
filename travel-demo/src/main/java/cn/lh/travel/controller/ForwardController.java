package cn.lh.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
    @RequestMapping("/index")
    public String toIndex() {
        return "main";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginFail")
    public String loginFail() {
        return "login-fail";
    }

    @RequestMapping("/testError")
    public String test() {
        int i = 1 / 0;
        return "login-fail";
    }

}
