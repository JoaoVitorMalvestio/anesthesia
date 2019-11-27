package br.uem.iss.anesthesia.model.business.exception;

public class IncorrectUserExpection extends BusinessRuleException {

    public IncorrectUserExpection() {
        super("Usuário ou senha inválidos.");
    }
}
