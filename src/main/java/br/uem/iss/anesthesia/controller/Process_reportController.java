package br.uem.iss.anesthesia.controller;

import br.uem.iss.anesthesia.model.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Process_reportController {
    @Autowired
    private Repor;

    @RequestMapping(method = RequestMethod.GET, value = "/index_process_report")
    public String inicio(){
        return  "index_process_report";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pesquisarprocessos")
    public String salvar(String data){
        processRepository.findByInicialDateBefore();
    }

}
