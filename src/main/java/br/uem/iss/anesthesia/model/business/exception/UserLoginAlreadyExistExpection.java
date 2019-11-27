package br.uem.iss.anesthesia.model.business.exception;

public class UserLoginAlreadyExistExpection extends BusinessRuleException {

    public UserLoginAlreadyExistExpection(String user) {
        super("Usuário [" + user + "] já existe.");
    }
}
