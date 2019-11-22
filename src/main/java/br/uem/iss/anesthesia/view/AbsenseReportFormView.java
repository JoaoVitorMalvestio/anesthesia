package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
import br.uem.iss.anesthesia.model.entity.ProcessModel;

public class AbsenseReportFormView extends AbstractModelAndView {

    public AbsenseReportFormView(ProcessReportRequest processReportRequest, Iterable<ProcessModel> process) {
        super("form_absense-report", "filter", processReportRequest);
        addObject("process", process);
    }
}
