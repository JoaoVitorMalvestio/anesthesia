package br.uem.iss.anesthesia.model.business.validator;

import org.springframework.stereotype.Component;

@Component
public class LoginNotNullValidator extends NotNullValidator {

    public LoginNotNullValidator() {
        super("Login");
    }
}
