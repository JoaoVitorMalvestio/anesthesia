package br.uem.iss.anesthesia.view;

import br.uem.iss.anesthesia.model.entity.ExamModel;

public class ExamFormView extends AbstractModelAndView {

    public ExamFormView(ExamModel exam, String message) {
        super("form_exam", "exam", exam);
        this.addObject("message", message);
        this.addObject("metodo", "Adicionar ");
    }
}