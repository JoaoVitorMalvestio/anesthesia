package br.uem.iss.anesthesia.model.business.validator;

import br.uem.iss.anesthesia.model.business.exception.NumberContendNotAllowedException;
import org.springframework.stereotype.Component;

@Component
public class NameNotNumbersValidator {

    public void validate(String data) throws NumberContendNotAllowedException {
        if (!data.matches("[a-zA-Z]+$")) {
            throw new NumberContendNotAllowedException("nome");
        }
    }
}