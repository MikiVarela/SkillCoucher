package com.example.myshop.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public")
public class MainController {

    @GetMapping({ "/", "/index", "" })
    public String showHome(@RequestParam() Optional<String> usuario,
            Model model) {
        int currentYear = LocalDate.now().getYear();
        model.addAttribute("year", currentYear);
        model.addAttribute("user", usuario.orElse(""));
        return "public/homeView";
    }

    @GetMapping("/pol")
    public String showPols() {
        return "public/politicasView";
    }

}
