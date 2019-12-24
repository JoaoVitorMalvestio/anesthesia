package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.model.entity.ExamModel;
import br.uem.iss.anesthesia.model.entity.UserModel;

public class Process_ReportIndexView extends AbstractModelAndView {

    public Process_ReportIndexView() {
        super("layouts/app");
        this.addObject("index_process_report", "index_process_report");

    }
}