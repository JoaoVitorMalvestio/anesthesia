package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.model.entity.AppointmentModel;
import br.uem.iss.anesthesia.model.entity.ExamModel;
import org.springframework.web.servlet.ModelAndView;

public class ConsultRegistryView extends ModelAndView {

    public ConsultRegistryView(AppointmentModel consultModel) {
        super("report_consult-registry", "consult", consultModel);
    }
}
