package br.uem.iss.anesthesia.model.business;

import br.uem.iss.anesthesia.model.business.exception.*;
import br.uem.iss.anesthesia.model.business.validator.LoginNotNullValidator;
import br.uem.iss.anesthesia.model.business.validator.PasswordNotNullValidator;
import br.uem.iss.anesthesia.model.entity.UserModel;
import br.uem.iss.anesthesia.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LoginUserBusiness extends SaveModelBusiness<UserModel> {
    private UserRepository repository;
    private LoginNotNullValidator loginNotNullValidator;
    private PasswordNotNullValidator passwordNotNullValidator;

    @Autowired
    public LoginUserBusiness(UserRepository userRepository, LoginNotNullValidator loginNotNullValidator, PasswordNotNullValidator passwordNotNullValidator) {
        super(userRepository);
        this.repository = userRepository;
        this.loginNotNullValidator = loginNotNullValidator;
        this.passwordNotNullValidator = passwordNotNullValidator;
    }

    @Override
    protected void saveDependencies(UserModel model) throws BusinessRuleException {

    }

    @Override
    protected void validateFields(UserModel model) throws NullContentNotAllowedException, IncorrectUserExpection {
        loginNotNullValidator.validate(model.getLogin());
        passwordNotNullValidator.validate(model.getPassword());

        Set<UserModel> found = repository.findByLoginContainingAndPasswordContaining(model.getLogin(),model.getPassword());
        if (found.isEmpty()) {
            throw new IncorrectUserExpection();
        }
    }

    public void login(UserModel model) throws BusinessRuleException {
        validateFields(model);
    }
}
