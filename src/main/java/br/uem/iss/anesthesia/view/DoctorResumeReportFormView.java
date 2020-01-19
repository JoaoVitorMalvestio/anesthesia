package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.controller.request.DoctorReportRequest;
import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
import br.uem.iss.anesthesia.model.entity.DoctorModel;
import br.uem.iss.anesthesia.model.entity.ProcessModel;

public class DoctorResumeReportFormView extends AbstractModelAndView {

    public DoctorResumeReportFormView(Iterable<ProcessModel> processModels){
        this(processModels, new ProcessReportRequest(), new DoctorReportRequest());

    }

    public DoctorResumeReportFormView(Iterable<ProcessModel> processModels, ProcessReportRequest filter, DoctorReportRequest doctorsModels) {
        super("form_doctor_resume-report", "filter", filter);
        addObject("process", processModels);
        addObject("doctors", doctorsModels);
    }
}

