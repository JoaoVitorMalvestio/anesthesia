package br.uem.iss.anesthesia.controller;

import br.uem.iss.anesthesia.model.business.LoginUserBusiness;
import br.uem.iss.anesthesia.model.entity.UserModel;
import br.uem.iss.anesthesia.view.HomeView;
import br.uem.iss.anesthesia.view.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.uem.iss.anesthesia.model.business.exception.BusinessRuleException;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(LoginController.HOME)
public class LoginController {

    public static final String HOME = "/login";

    @Autowired
    private LoginUserBusiness loginUserBusiness;

    @GetMapping
    public ModelAndView login() {
        return viewWithoutMessage(new UserModel());

        //return new ModelAndView("layouts/app", "conteudo", "login");
    }

    @PostMapping
    public ModelAndView loginIn(UserModel user) {
        try {
            loginUserBusiness.login(user);
            return new HomeView(user,null);
        } catch (BusinessRuleException e) {
            return viewWithMessage(user, e.getMessage());
        }
    }

    private LoginView viewWithoutMessage(UserModel user) {
        return viewWithMessage(user, null);
    }

    private LoginView viewWithMessage(UserModel user, String message) {
        return new LoginView(user,message);
    }
}
