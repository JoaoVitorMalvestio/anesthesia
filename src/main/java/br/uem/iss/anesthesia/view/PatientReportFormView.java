package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.controller.request.PatientReportRequest;
import br.uem.iss.anesthesia.model.entity.AppointmentModel;
import br.uem.iss.anesthesia.model.entity.DoctorModel;
import br.uem.iss.anesthesia.model.entity.PatientPerDoctorFilter;

public class PatientReportFormView extends AbstractModelAndView {

    public PatientReportFormView(Iterable<AppointmentModel> consults, Iterable<DoctorModel> doctors) {
        this(consults, new PatientPerDoctorFilter(), doctors, null);
    }

    public PatientReportFormView(Iterable<AppointmentModel> consults, PatientPerDoctorFilter filter,Iterable<DoctorModel> doctors, String message) {
        super("form_patient-report", "filter", filter);
        addObject("consults", consults);
        addObject("doctors", doctors);
        addObject("message", message);
    }
}
