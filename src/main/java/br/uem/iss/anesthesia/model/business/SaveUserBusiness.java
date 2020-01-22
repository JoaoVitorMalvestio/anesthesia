package br.uem.iss.anesthesia.model.business;

import br.uem.iss.anesthesia.model.business.exception.BusinessRuleException;
import br.uem.iss.anesthesia.model.business.exception.IncorrectUserExpection;
import br.uem.iss.anesthesia.model.business.exception.UserLoginAlreadyExistExpection;
import br.uem.iss.anesthesia.model.business.validator.NameNotNullValidator;
import br.uem.iss.anesthesia.model.business.validator.NameNotNumbersValidator;
import br.uem.iss.anesthesia.model.business.validator.PasswordNotNullValidator;
import br.uem.iss.anesthesia.model.entity.UserModel;
import br.uem.iss.anesthesia.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SaveUserBusiness extends SaveModelBusiness<UserModel> {
    private UserRepository repository;
    private NameNotNullValidator nameNotNullValidator;
    private NameNotNumbersValidator nameNotNumbersValidator;
    private PasswordNotNullValidator passwordNotNullValidator;

    @Autowired
    public SaveUserBusiness(UserRepository repository, NameNotNullValidator nameNotNullValidator, NameNotNumbersValidator nameNotNumbersValidator, PasswordNotNullValidator passwordNotNullValidator) {
        super(repository);
        this.repository = repository;
        this.nameNotNullValidator = nameNotNullValidator;
        this.nameNotNumbersValidator = nameNotNumbersValidator;
        this.passwordNotNullValidator = passwordNotNullValidator;
    }

    @Override
    protected void saveDependencies(UserModel model) {
    }

    @Override
    protected void validateFields(UserModel model) throws BusinessRuleException {
        nameNotNullValidator.validate(model.getLogin());
        nameNotNumbersValidator.validate(model.getLogin());
        passwordNotNullValidator.validate(model.getPassword());

        boolean novo = model.getId() == null;

        Set<UserModel> found = repository.findByLoginContaining(model.getLogin());
        if (!found.isEmpty() && novo) {
            throw new UserLoginAlreadyExistExpection(model.getLogin());
        }
    }
}
