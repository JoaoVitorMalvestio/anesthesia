package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.model.entity.AppointmentModel;
import br.uem.iss.anesthesia.model.entity.DoctorModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class DoctorResumeReportView extends ModelAndView {

    public DoctorResumeReportView(String initial, String end, DoctorModel doctor, List<AppointmentModel> appointments) {
        super( "report_doctor_resume-report", "appointments", appointments);
        String description = "Consultas";
        if (doctor != null) {
            description += " com o médico " + doctor.getName();
        }
        description += " de " + initial + " a " + end;
        addObject("description", description);
    }
}
