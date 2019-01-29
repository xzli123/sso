package com.xiaoyiyiyo.server.controller;

import com.xiaoyiyiyo.server.common.constant.AuthConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaoyiyiyo on 2018/5/1.
 */
@Controller
public class IndexController {

    @GetMapping("/sso")
    public String index(HttpServletRequest request, ModelMap modelMap) {
        modelMap.addAttribute("clientUrl", request.getParameter(AuthConst.CLIENT_URL));
        modelMap.addAttribute("sessionId", request.getSession().getId());
        return "index";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @RequestMapping("/")
    public String server(HttpServletRequest request, ModelMap modelMap) {
        modelMap.addAttribute("clientUrl", request.getParameter(AuthConst.CLIENT_URL));
        modelMap.addAttribute("sessionId", request.getSession().getId());
        return "login";
    }
}
