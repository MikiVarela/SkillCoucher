package com.example.myshop.controllers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myshop.domain.Categoria;
import com.example.myshop.domain.Arma;
import com.example.myshop.services.ArmaService;
import com.example.myshop.services.CategoriaService;

@Controller
@RequestMapping("/over")
public class OverController {

    @Autowired
    public ArmaService armaService;
    @Autowired
    public CategoriaService categoriaService;

    @GetMapping({ "", "/" })
    public String showList(Model model) {
        model.addAttribute("listaArmas", armaService.obtenerTodos());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        model.addAttribute("categoriaSeleccionada", new Categoria(0L, "Todas"));
        return "over/overView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("armaForm", new Arma());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "arma/armaNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid Arma armaForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "arma/armaNewView";
        armaService.añadir(armaForm);
        return "redirect:/armas/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Arma arma = armaService.obtenerPorId(id);
        if (arma != null) {
            model.addAttribute("armaForm", arma);
            model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
            return "arma/armaEditView";
        } else {
            return "redirect:/armas/";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid Arma armaForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "arma/armaEditView";
        } else {
            armaService.editar(armaForm);
            return "redirect:/armas/";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        armaService.delete(id);
        return "redirect:/armas/";
    }

    @GetMapping("/porCateg/{idCat}")
    public String showListInCategory(@PathVariable Long idCat, Model model) {
        model.addAttribute("listaArmas", armaService.obtenerPorCategoria(idCat));
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        model.addAttribute("categoriaSeleccionada", categoriaService.obtenerPorId(idCat));
        return "arma/armaListView";
    }
}
