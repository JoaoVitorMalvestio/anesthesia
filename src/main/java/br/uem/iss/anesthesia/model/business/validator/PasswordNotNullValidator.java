package br.uem.iss.anesthesia.model.business.validator;

import org.springframework.stereotype.Component;

@Component
public class PasswordNotNullValidator extends NotNullValidator {

    public PasswordNotNullValidator() {
        super("Senha");
    }
}
