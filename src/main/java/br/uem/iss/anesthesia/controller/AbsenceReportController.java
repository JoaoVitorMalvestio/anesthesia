package br.uem.iss.anesthesia.controller;


import br.uem.iss.anesthesia.model.entity.AppoinmentFilter;
import br.uem.iss.anesthesia.model.repository.AppointmentRepository;
import br.uem.iss.anesthesia.util.DateSupport;
import br.uem.iss.anesthesia.view.AbstractModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/absence")
public class AbsenceReportController extends AbstractController {
    private AppointmentRepository appointmentRepository;
    private DateSupport dateSupport;

    public AbsenceReportController(AppointmentRepository appointmentRepository, DateSupport dateSupport){
        this.appointmentRepository = appointmentRepository;
        this.dateSupport = dateSupport;
    }

    //@RequestMapping
    @GetMapping
    public ModelAndView absenceRegistry(@ModelAttribute("filter") AppoinmentFilter filter) {
       // return new AppoinmentRegistryView((AppointmentModel) appointmentRepository.findByDateBetween(converteData(filter.getInitial()),  converteData(filter.getEnd())));
       return new AbstractModelAndView("absence_report");
    }

    private LocalDateTime converteData(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(data + " 00:00:00.000", formatter);
        return dateTime;
    }
}
