package br.uem.iss.anesthesia.model.exception;

import br.uem.iss.anesthesia.model.business.exception.BusinessRuleException;

public class PatientWithoutContactException extends BusinessRuleException {

    public PatientWithoutContactException() {
        super("Paciente precisa de ao menos uma informação de contato");
    }
}
