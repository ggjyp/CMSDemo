package com.jyp.CMSDemo.controller;

import com.jyp.CMSDemo.pojo.User;
import com.jyp.CMSDemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author   : jyp
 * Date     : 2017/3/7 15:49
 * Describe : 用户控制模块
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    UserService userService;

    //通用用户功能
    @RequestMapping("/login")
    public String login(String name, String password, String codevalidate, RedirectAttributes attr, HttpSession session, HttpServletResponse response) {
        String code = (String) session.getAttribute("codeValidate");
        if (codevalidate == null || !codevalidate.equalsIgnoreCase(code)){
            attr.addFlashAttribute("error","验证码错误");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(name,password) ;
        try {
            subject.login(token);
            session.setAttribute("name", name);
            return "index" ;
        }catch (Exception e){
            return "login" ;
        }
    }
}
