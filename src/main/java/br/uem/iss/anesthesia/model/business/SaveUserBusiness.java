package br.uem.iss.anesthesia.model.business;

import br.uem.iss.anesthesia.model.business.exception.BusinessRuleException;
import br.uem.iss.anesthesia.model.business.validator.NameNotNullValidator;
import br.uem.iss.anesthesia.model.business.validator.NameNotNumbersValidator;
import br.uem.iss.anesthesia.model.entity.UserModel;
import br.uem.iss.anesthesia.model.repository.MedicalProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveUserBusiness extends SaveModelBusiness<UserModel> {

    private NameNotNullValidator nameNotNullValidator;
    private NameNotNumbersValidator nameNotNumbersValidator;

    @Autowired
<<<<<<< HEAD
    public SaveUserBusiness(MedicalProcedureRepository repository, NameNotNullValidator nameNotNullValidator) {
        super(repository);
        this.nameNotNullValidator = nameNotNullValidator;
=======
    public SaveUserBusiness(MedicalProcedureRepository repository, NameNotNullValidator nameNotNullValidator, NameNotNumbersValidator nameNotNumbersValidator) {
        super(repository);
        this.nameNotNullValidator = nameNotNullValidator;
        this.nameNotNumbersValidator = nameNotNumbersValidator;
>>>>>>> 0efc57b1bbb1ecd82e921f7d8aaba9ce98b7867d
    }

    @Override
    protected void saveDependencies(UserModel model) {
    }

    @Override
    protected void validateFields(UserModel model) throws BusinessRuleException {
        nameNotNullValidator.validate(model.getLogin());
        nameNotNumbersValidator.validate(model.getLogin());
        nameNotNullValidator.validate(model.getPassword());
    }
}
