package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.controller.request.DoctorReportRequest;
import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
import br.uem.iss.anesthesia.model.entity.*;

public class DoctorResumeReportFormView extends AbstractModelAndView {

    public DoctorResumeReportFormView(Iterable<DoctorModel> doctors, String name, String crm, boolean ativo) {
        super("form_doctor_resume-report", "doctors", doctors);
        this.addObject("filtro_name", name);
        this.addObject("filtro_crm", crm);
        this.addObject("filtro_ativo", ativo);
    }

}

