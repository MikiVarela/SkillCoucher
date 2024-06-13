package com.example.myshop.controllers;

// import jakarta.validation.Valid;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myshop.domain.Categoria;
// // import com.example.myshop.domain.Arma;
// // import com.example.myshop.services.ArmaService;
import com.example.myshop.services.CategoriaService;

@Controller
@RequestMapping("/elden")
public class EldenController {

    // @Autowired
    // public ArmaService armaService;
    // @Autowired
    // public ApiService apiService;
    @Autowired
    public CategoriaService categoriaService;

    @GetMapping({ "", "/" })
    public String showList(Model model) {
        // model.addAttribute("listaArmas", apiService.getWeapons());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        model.addAttribute("categoriaSeleccionada", new Categoria(0L, "Todas"));
        return "eldenring/eldenView";
    }

    // // @GetMapping("/weapons")
    // // public String getWeapons(Model model) {
    // //     List<Arma> weapons = apiService.getWeapons();
    // //     model.addAttribute("weapons", weapons);
    // //     return "eldenring/weapons";
    // // }

    // @GetMapping("/new")
    // public String showNew(Model model) {
    //     model.addAttribute("armaForm", new Arma());
    //     model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
    //     return "arma/armaNewView";
    // }

    // @PostMapping("/new/submit")
    // public String showNewSubmit(
    //         @Valid Arma armaForm,
    //         BindingResult bindingResult) {
    //     if (bindingResult.hasErrors())
    //         return "arma/armaNewView";
    //     armaService.añadir(armaForm);
    //     return "redirect:/armas/";
    // }

    // @PostMapping("/edit/submit")
    // public String showEditSubmit(@Valid Arma armaForm,
    //         BindingResult bindingResult) {

    //     if (bindingResult.hasErrors()) {
    //         return "arma/armaEditView";
    //     } else {
    //         armaService.editar(armaForm);
    //         return "redirect:/armas/";
    //     }
    // }

}
