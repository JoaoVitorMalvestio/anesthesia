package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.controller.request.PatientReportRequest;
import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
import br.uem.iss.anesthesia.model.entity.DoctorModel;
import br.uem.iss.anesthesia.model.entity.PatientModel;
import br.uem.iss.anesthesia.model.entity.ProcessModel;

public class AbsenseReportFormView extends AbstractModelAndView {

    public AbsenseReportFormView(Iterable<ProcessModel> processModels){
        this(processModels, new ProcessReportRequest());


    public AbsenseReportFormView(Iterable<ProcessModel> processModels, ProcessReportRequest filter) {
        super("form_absence-report", "filter", filter);
        addObject("process", processModels);
    }

}
