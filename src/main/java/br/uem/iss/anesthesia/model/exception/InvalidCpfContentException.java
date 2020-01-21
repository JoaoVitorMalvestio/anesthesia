package br.uem.iss.anesthesia.model.exception;

import br.uem.iss.anesthesia.model.business.exception.BusinessRuleException;

public class InvalidCpfContentException extends BusinessRuleException {

    public InvalidCpfContentException() {
        super("Conteúdo do CPF inválido");
    }
}
