package com.example.myshop.controllers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myshop.domain.Comentario;
import com.example.myshop.services.ArmaService;
import com.example.myshop.services.UsuarioService;
import com.example.myshop.services.ComentarioService;

@Controller
@RequestMapping("/com")
public class ComentarioController {

    @Autowired
    public ArmaService armaService;

    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    public ComentarioService comentarioService;

    @GetMapping("/arma/{id}")
    public String showListProductos(@PathVariable Long id, Model model) {
        model.addAttribute("listaComentario",
                comentarioService.obtenerTodosPorArma(armaService.obtenerPorId(id)));
        return "comentario/comentarioListView";
    }

    @GetMapping("/usuario/{id}")
    public String showListUsuarios(@PathVariable Long id, Model model) {
        model.addAttribute("listaComentario",
                comentarioService.obtenerTodosPorUsuario(usuarioService.obtenerPorId(id)));
        return "comentario/comentarioListView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
        model.addAttribute("listaArmas", armaService.obtenerTodos());
        model.addAttribute("comentariosForm", new Comentario());
        return "comentario/comentarioNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("comentariosForm") Comentario nuevoComentario,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "comentario/comentarioNewView";
        comentarioService.añadir(nuevoComentario);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id, Model model) {
        comentarioService.borrar(id);
        return "redirect:/";
    }
}
