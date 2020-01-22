package br.uem.iss.anesthesia.controller;

import br.uem.iss.anesthesia.controller.AbstractController;
import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
import br.uem.iss.anesthesia.model.entity.*;
import br.uem.iss.anesthesia.model.repository.AppointmentRepository;
import br.uem.iss.anesthesia.model.repository.DoctorRepository;
import br.uem.iss.anesthesia.model.repository.PatientRepository;
import br.uem.iss.anesthesia.model.repository.ProcessRepository;

import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
import br.uem.iss.anesthesia.model.entity.ProcessModel;
import br.uem.iss.anesthesia.model.repository.*;
import br.uem.iss.anesthesia.util.DateSupport;
import br.uem.iss.anesthesia.view.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController extends AbstractController {

    private ExamRepository examRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private ProcessRepository processRepository;
    private AppointmentRepository appointmentRepository;
    private MedicalProcedureRepository medicalProcedureRepository;
    private DateSupport dateSupport;


    public ReportController(MedicalProcedureRepository medicalProcedureRepository, ExamRepository examRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, DateSupport dateSupport, ProcessRepository processRepository) {
        this.examRepository = examRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.processRepository = processRepository;
        this.medicalProcedureRepository = medicalProcedureRepository;
        this.appointmentRepository = appointmentRepository;
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


    @GetMapping("/patient-report")
    public AbstractModelAndView patientReport() {
        LocalDateTime initialDay = LocalDate.now().atStartOfDay();
        LocalDateTime finalDay = LocalDate.now().plusDays(1).atStartOfDay();
        return new PatientReportFormView(appointmentRepository.findByDateBetween(initialDay,finalDay),doctorRepository.findAll());
    }

    @PostMapping("/patient-report")
    public AbstractModelAndView patientReportFilter(PatientPerDoctorFilter filter) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDateTime initialDay;
        LocalDateTime finalDay;
        List<AppointmentModel> consults;

        if (filter.getInitial().equals("")) {
            initialDay = LocalDate.now().atStartOfDay();
        }
        else {
            initialDay = LocalDate.parse(filter.getInitial(), formatter).atStartOfDay();
        }

        if (filter.getEnd().equals("")) {
            finalDay = LocalDate.now().plusDays(1).atStartOfDay();
        }
        else {
            finalDay = LocalDate.parse(filter.getEnd(), formatter).plusDays(1).atStartOfDay();
        }

        if (filter.getDoctor() == null)
            consults = appointmentRepository.findByDateBetween(initialDay,finalDay);
        else
            consults = appointmentRepository.findByDateBetweenAndDoctor(initialDay,finalDay,filter.getDoctor());

        return new PatientReportFormView(consults,filter,doctorRepository.findAll(),null);
    }
    
    @GetMapping("/exam-registry/{id}")
    public ModelAndView examRegistry(@PathVariable Long id) {
        return new ExamRegistryView(examRepository.findById(id).get());
    }

    @GetMapping("/consult-registry/{id}")
    public ModelAndView consultRegistry(@PathVariable Long id) {
        return new ConsultRegistryView(appointmentRepository.findById(id).get());
    }


    @GetMapping("/doctor_resume-report")
    public DoctorResumeReportFormView formDoctorResumeReport() {
        return new DoctorResumeReportFormView(processRepository.findAll());
    }

    @GetMapping("/process-report")
    public AbstractModelAndView formProcessReport() {
        return new ProcessReportFormView(patientRepository.findAll(), new ProcessReportRequest(), null);
    }

    @PostMapping("/process-report")
    public ModelAndView processReport(@ModelAttribute ProcessReportRequest request) {
        Iterable<ProcessModel> process;
        if(request.getInitial() != null && request.getEnd() != null && request.getPatient() != null){
            process = processRepository.findByInicialDateAfterAndInicialDateBeforeAndPatientEquals(request.getInitial(), request.getEnd(), request.getPatient());
        }else if(request.getInitial() != null && request.getEnd() != null ){
            process = processRepository.findByInicialDateAfterAndInicialDateBefore(request.getInitial(), request.getEnd());
        }else if(request.getInitial() != null && request.getPatient() != null ){
            process = processRepository.findByInicialDateAfterAndPatientEquals(request.getInitial(), request.getPatient());
        }else if(request.getEnd() != null && request.getPatient() != null){
            process = processRepository.findByInicialDateBeforeAndPatientEquals(request.getInitial(), request.getPatient());
        }else if(request.getEnd() != null){
            process = processRepository.findByInicialDateBefore(request.getEnd());
        }else if(request.getPatient() != null){
            process = processRepository.findByPatientEquals(request.getPatient());
        }else if (request.getInitial() != null){
            process = processRepository.findByInicialDateAfter(request.getInitial());
        }else{
            process = processRepository.findByActiveTrue();
        }
        return new ProcessReportFormView(patientRepository.findAll(), request, process);
    }

    @GetMapping("/absence-report")
    public AbstractModelAndView formAbsenceReport() {
        return new AbsenseReportFormView(processRepository.findAll());
    }

    @GetMapping("/advanced-report")
    public AbstractModelAndView formAdvancedReport(){
        return new AdvancedReportFormView(processRepository.findAll());
    }

  /*  @getMapping("/crud-report")
    public AbstractModelAndView formRegisterReport(){
        return new
    }*/
    /*@PostMapping("/patient-report")
    public ModelAndView patientReport(@ModelAttribute PatientReportRequest request) {
        LocalDateTime initial = request.getInitial().atStartOfDay();
        LocalDateTime end = request.getEnd().atTime(23, 59, 59);
        List<AppointmentModel> appointments;
        DoctorModel doctor = request.getDoctor();
        if (doctor == null) {
            appointments = appointmentRepository.findByDateBetween(initial, end);
        } else {
            appointments = appointmentRepository.findByDoctorAndDateBetween(initial, end);
        }
        return new PatientReportView(dateSupport.format(initial), dateSupport.format(end), doctor, appointments);
    }*/
    
    @GetMapping("/listagem-report")
    public AbstractModelAndView listagenReport() {
        long sqlPacientes = patientRepository.count();
        long sqlDoctor = doctorRepository.count();
        long sqlConsultas = appointmentRepository.count();
        long sqlProcess = processRepository.count();
        AbstractModelAndView mv = new AbstractModelAndView("new_report_listagem");
        mv.addObject("pacientes",sqlPacientes);
        mv.addObject("doctors", sqlDoctor);
        mv.addObject("consults", sqlConsultas);
        mv.addObject("processos", sqlProcess);
        return mv;
    }
    
    @GetMapping("/doctor_resume2-report/{id}")
    public AbstractModelAndView doctorResumeReport(@PathVariable Long id) {
        String sqlDoctorName = doctorRepository.findById(id).get().getName();
        String sqlDoctorCRM = doctorRepository.findById(id).get().getCrm();
        long sqlConsults = appointmentRepository.count();
        long sqlMedicalProcedure = medicalProcedureRepository.count();
        long sqlProcess = processRepository.count();
        long sqlPatient = patientRepository.count();
        long sqlExam = examRepository.count();
        AbstractModelAndView mv = new AbstractModelAndView("new_report_doctor_resume");
        mv.addObject("doctorName", sqlDoctorName);
        mv.addObject("doctorCRM", sqlDoctorCRM);
        mv.addObject("consults", sqlConsults);
        mv.addObject("medicalProcedure", sqlMedicalProcedure);
        mv.addObject("process", sqlProcess);
        mv.addObject("patient",sqlPatient);
        mv.addObject("exam", sqlExam);
        return mv;
    }
}