package br.uem.iss.anesthesia.controller;


import br.uem.iss.anesthesia.model.entity.AppoinmentFilter;
import br.uem.iss.anesthesia.model.entity.AppointmentModel;
import br.uem.iss.anesthesia.model.repository.AppointmentRepository;
import br.uem.iss.anesthesia.util.DateSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/doctorResume")
public class DoctorResumeReportController extends AbstractController {
    private AppointmentRepository appointmentRepository;
    private DateSupport dateSupport;

    public DoctorResumeReportController(AppointmentRepository appointmentRepository, DateSupport dateSupport){
        this.appointmentRepository = appointmentRepository;
        this.dateSupport = dateSupport;
    }

    @GetMapping
    public ModelAndView doctorResumeRegistry(@ModelAttribute("filter") AppoinmentFilter filter) {
        List<AppointmentModel> listaTodos = appointmentRepository.findByDateBetween(converteData(filter.getInitial()), converteData(filter.getEnd()));
        ModelAndView mv = new ModelAndView("doctor_resume_report");
        mv.addObject("resumo", listaTodos);
        return mv;
    }

    private LocalDateTime converteData(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(data + " 00:00:00.000", formatter);
        return dateTime;
    }
}
