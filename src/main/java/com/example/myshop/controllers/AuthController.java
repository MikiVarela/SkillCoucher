package com.example.myshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        @RequestParam("passwordConfirm") String passwordConfirm,
        Model model) {

        if (!password.equals(passwordConfirm)) {
            model.addAttribute("error", "Passwords do not match.");
            return "signup";
        }

        // Aquí debes agregar la lógica para guardar el usuario en tu base de datos
        // Ejemplo:
        // User newUser = new User(username, passwordEncoder.encode(password));
        // userRepository.save(newUser);

        return "redirect:/login";
    }
}