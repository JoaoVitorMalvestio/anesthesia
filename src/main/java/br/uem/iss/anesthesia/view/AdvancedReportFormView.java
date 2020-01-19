package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
import br.uem.iss.anesthesia.model.entity.ProcessModel;

public class AdvancedReportFormView extends AbstractModelAndView {

    public AdvancedReportFormView(Iterable<ProcessModel> processModels){
        this(processModels, new ProcessReportRequest());

    }

    public AdvancedReportFormView(Iterable<ProcessModel> processModels, ProcessReportRequest filter) {
        super("form_advance-report", "filter", filter);
        addObject("process", processModels);
    }
}
