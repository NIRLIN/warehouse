package cn.edu.gues.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/14 22:00
 */

@Controller
public class PageController {
    @RequestMapping(name = "login.html", value = "/")
    public String index() {
        return "login";
    }
    @RequestMapping(name = "login.html", value = "login.html")
    public String login() {
        return "login";
    }

    @RequestMapping(name = "noLogin",value = "noLogin.html")
    public String noLogin(HttpSession session){
        session.removeAttribute("jobNo");
        session.removeAttribute("name");
        session.removeAttribute("role");
        return "redirect:login.html";
    }

}
