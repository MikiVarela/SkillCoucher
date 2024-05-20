package com.example.myshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/404")
    public String show404View() {
        return "error/404";
    }
    @GetMapping("/403")
    public String show403View() {
        return "error/403";
    }
    @GetMapping("/500")
    public String show500View() {
        return "error/500";
    }
}
