package com.jyp.CMSDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author   : jyp
 * Date     : 2017/3/7 10:53
 * Describe :
 */
@Controller
public class RouteController {
    @RequestMapping(value = "")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "index")
    public String index() { return "index";}

    @RequestMapping(value = "page_manager")
    public String page_manager() {return "page_manager";}

    @RequestMapping(value = "unAuthorization")
    public String unAuthorization() {return "unAuthorization";}

    @RequestMapping(value = "rest_json")
    public String restJson() {return "get_rest_json";}
}
