package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.MyAuthenticationUtil;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String handleError(Model model, Authentication authentication, HttpServletRequest request, HttpTrace trace) {
        MyAuthenticationUtil.addToModelAuthDetails(model, authentication);
        /*Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String kod = status.toString();
        Integer kod1 = trace.getResponse().getStatus();*/
        String test = "test";
        model.addAttribute("errorCode", test);
        return "error";
    }
}
