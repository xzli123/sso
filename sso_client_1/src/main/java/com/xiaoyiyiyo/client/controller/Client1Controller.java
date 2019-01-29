package com.xiaoyiyiyo.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaoyiyiyo on 2018/5/6.
 */
@Controller
public class Client1Controller {

    @GetMapping("/index")
    public String index(HttpServletRequest request, ModelMap modelMap) {
        modelMap.addAttribute("sessionId", request.getSession().getId());
        return "index";
    }

    @GetMapping("/client")
    public String client(HttpServletRequest request, ModelMap modelMap) {
        modelMap.addAttribute("sessionId", request.getSession().getId());
        return "client";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, @RequestParam("TOKEN") String token, ModelMap modelMap) {
        modelMap.addAttribute("sessionId", request.getSession().getId());
        modelMap.addAttribute("token", token);
        return "login";
    }
}
