package com.example.myshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myshop.domain.Rol;
import com.example.myshop.domain.Usuario;
import com.example.myshop.services.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping({ "/", "/list", "" })
    public String showList(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
        return "user/userListView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("usuarioForm", new Usuario());
        return "user/userNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("usuarioForm") Usuario nuevoUsuario,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "user/userNewView";
        nuevoUsuario.setRol(Rol.USUARIO);
        usuarioService.añadir(nuevoUsuario);
        return "redirect:/public/";
    }

    // Cambiar desde rol alto (No lo pide el ejercicio)
    // @GetMapping("/edit/{id}")
    // public String showEditForm(@PathVariable long id, Model model) {
    // Usuario usuario = usuarioService.obtenerPorId(id);
    // if (usuario != null) {
    // model.addAttribute("usuarioForm", usuario);
    // return "user/userEditView";
    // } else {
    // return "redirect:/user/";
    // }
    // }

    @GetMapping("/edit")
    public String showEditFormSinId(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            model.addAttribute("usuarioForm", usuarioService.obtenerPorNombre(currentUserName));
            return "user/userEditView";
        } else {
            return "redirect:/user/";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid @ModelAttribute("usuarioForm") Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/userEditView";
        } else {
            usuarioService.editar(usuario);
            return "redirect:/public/";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id, Model model) {
        usuarioService.borrar(id);
        model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
        return "user/userListView";
    }
}
