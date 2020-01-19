package br.uem.iss.anesthesia.model.exception;

import br.uem.iss.anesthesia.model.business.exception.BusinessRuleException;

public class NullContentNotAllowedException extends BusinessRuleException {

    public NullContentNotAllowedException(String field) {
        super(field + " não pode ser vazio");
    }
}
