package br.uem.iss.anesthesia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helpController {

    @GetMapping("/help")
    public String ajuda(){
        return "help";
    }
}
