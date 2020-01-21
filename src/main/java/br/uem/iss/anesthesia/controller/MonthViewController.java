package br.uem.iss.anesthesia.controller;

import br.uem.iss.anesthesia.model.entity.AppointmentModel;
import br.uem.iss.anesthesia.model.entity.DoctorModel;
import br.uem.iss.anesthesia.model.entity.PatientModel;
import br.uem.iss.anesthesia.view.AbstractModelAndView;
import br.uem.iss.anesthesia.view.MonthViewView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/month-view")
public class MonthViewController extends AbstractController {

    @GetMapping
    public AbstractModelAndView home() {

        return new MonthViewView( );
    }


}
