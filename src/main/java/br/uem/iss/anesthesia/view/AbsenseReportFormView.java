package br.uem.iss.anesthesia.view;

<<<<<<< HEAD
<<<<<<< HEAD
import br.uem.iss.anesthesia.controller.request.PatientReportRequest;
import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
import br.uem.iss.anesthesia.model.entity.DoctorModel;
import br.uem.iss.anesthesia.model.entity.PatientModel;
=======
import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
>>>>>>> f2cb81d5208346219204bead1f48e680b0c4c620
=======
import br.uem.iss.anesthesia.controller.request.ProcessReportRequest;
>>>>>>> 30cc70466419f09ac867ac40b700c24b5147d65e
import br.uem.iss.anesthesia.model.entity.ProcessModel;

public class AbsenseReportFormView extends AbstractModelAndView {

<<<<<<< HEAD
    public AbsenseReportFormView(ProcessReportRequest processReportRequest, Iterable<ProcessModel> process) {
        super("form_absense-report", "filter", processReportRequest);
        addObject("process", process);
    }
=======
    public AbsenseReportFormView(Iterable<ProcessModel> processModels){
        this(processModels, new ProcessReportRequest());

    }

    public AbsenseReportFormView(Iterable<ProcessModel> processModels, ProcessReportRequest filter) {
        super("form_absence-report", "filter", filter);
        addObject("process", processModels);
    }

>>>>>>> 30cc70466419f09ac867ac40b700c24b5147d65e
}
