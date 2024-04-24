package com.example.myshop.controllers;

import java.time.LocalDate;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myshop.domain.ContactFormInfo;

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

    @GetMapping("/contacta")
    public String formuContacta(Model model) {
        model.addAttribute("contactFormInfo", new ContactFormInfo());
        return "public/contactView";
    }

    @PostMapping("/contacta/submit")
    public String formuContactaSubmit(@Valid @ModelAttribute ContactFormInfo contactFormInfo,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors())
            return "redirect:/contacta";
        else
            return "public/contactProcessedView";
    }

    @GetMapping("/aboutUsView")
    public String usView() {
        return "public/aboutUsView";
    }

}
