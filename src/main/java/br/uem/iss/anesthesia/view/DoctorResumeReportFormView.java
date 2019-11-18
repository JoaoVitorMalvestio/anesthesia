package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.controller.request.DoctorResumeReportRequest;
import br.uem.iss.anesthesia.controller.request.PatientReportRequest;
import br.uem.iss.anesthesia.model.entity.DoctorModel;

public class DoctorResumeReportFormView extends AbstractModelAndView {
    public DoctorResumeReportFormView(Iterable<DoctorModel> doctors) {
        this(doctors, new DoctorResumeReportRequest(), null);
    }

    public DoctorResumeReportFormView(Iterable<DoctorModel> doctors, DoctorResumeReportRequest filter, String message) {
        super("form_doctor_resume-report", "filter", filter);
        addObject("doctors", doctors);
        addObject("message", message);
    }
}
