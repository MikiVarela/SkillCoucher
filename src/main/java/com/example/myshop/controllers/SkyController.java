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

import java.util.List;

import com.example.myshop.domain.Sky;
import com.example.myshop.repositories.SkyRepository;
import com.example.myshop.services.SkyService;
import com.example.myshop.services.CategoriaService;

@Controller
@RequestMapping("/sky")
public class SkyController {

    @Autowired
    private SkyRepository skyRepository;
    @Autowired
    public SkyService skyService;
    @Autowired
    public CategoriaService categoriaService;

    @GetMapping({ "", "/" })
    public String showList(Model model) {
        List<Sky> datos = skyRepository.findAll();
        model.addAttribute("datosSky", datos);
        return "sky/skyView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("skyForm", new Sky());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "sky/skyNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid Sky skyForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "sky/skyNewView";
            skyService.añadir(skyForm);
        return "redirect:/sky/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Sky sky = skyService.obtenerPorId(id);
        if (sky != null) {
            model.addAttribute("skyForm", sky);
            model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
            return "sky/skyEditView";
        } else {
            return "redirect:/sky/";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid Sky skyForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "sky/skyEditView";
        } else {
            skyService.editar(skyForm);
            return "redirect:/sky/";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id, Model model) {
        skyService.borrar(id);
        return "redirect:/sky/";
    }

}
