package br.uem.iss.anesthesia.controller;

import br.uem.iss.anesthesia.controller.request.PatientReportRequest;
import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
import br.uem.iss.anesthesia.model.entity.DoctorModel;
import br.uem.iss.anesthesia.model.entity.PatientModel;
import br.uem.iss.anesthesia.model.entity.ProcessModel;
import br.uem.iss.anesthesia.model.repository.DoctorRepository;
import br.uem.iss.anesthesia.model.repository.PatientRepository;
import br.uem.iss.anesthesia.model.repository.ProcessRepository;
import br.uem.iss.anesthesia.util.DateSupport;
import br.uem.iss.anesthesia.view.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController extends AbstractController {

    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private ProcessRepository processRepository;
    private DateSupport dateSupport;


    public ReportController(PatientRepository patientRepository, DoctorRepository doctorRepository, DateSupport dateSupport, ProcessRepository processRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.processRepository = processRepository;
        this.dateSupport = dateSupport;
        this.processRepository = processRepository;
    }

    @GetMapping
    public AbstractModelAndView home() {
        return new AbstractModelAndView("report_index");
    }

    @GetMapping("/patient-registry/{id}")
    public ModelAndView patientRegistry(@PathVariable Long id) {
        return new PatientRegistryView(patientRepository.findById(id).get());
    }
}
