package com.example.myshop.controllers;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myshop.domain.Over;
import com.example.myshop.repositories.OverRepository;
import com.example.myshop.services.OverService;
import com.example.myshop.services.CategoriaService;

@Controller
@RequestMapping("/over")
public class OverController {

    @Autowired
    private OverRepository overRepository;
    @Autowired
    public OverService overService;
    @Autowired
    public CategoriaService categoriaService;

    @GetMapping({ "", "/" })
    public String showList(Model model) {
        List<Over> datos = overRepository.findAll();
        model.addAttribute("datosOver", datos);
        return "over/overView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("overForm", new Over());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "over/overNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid Over overForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "over/overNewView";
        overService.añadir(overForm);
        return "redirect:/over/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Over over = overService.obtenerPorId(id);
        if (over != null) {
            model.addAttribute("overForm", over);
            model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
            return "over/overEditView";
        } else {
            return "redirect:/over/";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid @ModelAttribute("overForm") Over over,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "over/overEditView";
        } else {
            overService.editar(over);
            return "redirect:/over/";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id, Model model) {
        overService.borrar(id);
        return "redirect:/over/";
    }
}
