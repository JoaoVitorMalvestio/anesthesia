package br.uem.iss.anesthesia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Process_reportController {
    @GetMapping("/index_process_report")
    public ModelAndView home() {
        return new ModelAndView("layouts/app", "conteudo", "index_process_report");
    }
}
