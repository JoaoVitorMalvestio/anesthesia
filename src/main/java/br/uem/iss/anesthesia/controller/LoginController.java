package br.uem.iss.anesthesia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView home() {
        return new ModelAndView("layouts/app", "conteudo", "login");
    }

    @PostMapping("")
    public ModelAndView loginIn() { return new ModelAndView("layouts/app", "conteudo", "login"); }
}
