package com.danico.danicoservices.controllers;

import com.danico.danicoservices.repositories.PatroonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatroonController {

    @Autowired
    private PatroonRepository patroonRepository;

    @RequestMapping({"/patronen"})
    public String getPatronen(Model model){

        model.addAttribute("patronen", patroonRepository.findAll());

        return "patronen";
    }
}
