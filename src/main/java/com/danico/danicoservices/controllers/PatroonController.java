package com.danico.danicoservices.controllers;

import com.danico.danicoservices.commands.PatroonCommand;
import com.danico.danicoservices.services.PatroonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatroonController {

    @Autowired
    private PatroonService patroonService;

    public PatroonController(PatroonService patroonService) {
        this.patroonService = patroonService;
    }

    @RequestMapping({"/patronen"})
    public String getPatronen(Model model){

        model.addAttribute("patronen", patroonService.getPatronen());

        return "patronen";
    }

    @RequestMapping({"/patronen/show/{id}"})
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("patroon", patroonService.findById(new Long(id)));

        return "patronen/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new PatroonCommand());

        return "patroon/patroonform";
    }

    @PostMapping
    @RequestMapping(name = "recipe")
    public String saveOrUpdate(@ModelAttribute PatroonCommand command) {
        PatroonCommand savedCommand = patroonService.savePatroonCommand(command);

        return "redirect:/patroon/show" + savedCommand.getId();
    }
}
