package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.model.entity.ExamModel;
import org.springframework.web.servlet.ModelAndView;

public class ExamRegistryView extends ModelAndView {

    public ExamRegistryView(ExamModel examModel) {
        super("report_exam-registry", "exam", examModel);
    }
}
