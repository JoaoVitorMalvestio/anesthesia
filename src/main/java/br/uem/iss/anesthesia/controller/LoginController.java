package br.uem.iss.anesthesia.controller;

import br.uem.iss.anesthesia.model.business.LoginUserBusiness;
import br.uem.iss.anesthesia.model.entity.UserModel;
import br.uem.iss.anesthesia.view.HomeView;
import br.uem.iss.anesthesia.view.LoginView;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    public static final String HOME = "/login";

    @Autowired
    private LoginUserBusiness loginUserBusiness;

    @GetMapping
    public ModelAndView login(HttpSession session) {
        UserModel userLogado = (UserModel) session.getAttribute("usuarioLogado");

        if (userLogado != null)
            return new HomeView(null);

        return viewWithoutMessage(new UserModel());
    }

    @PostMapping
    public ModelAndView loginIn(UserModel user, HttpSession session) {
        try {
            loginUserBusiness.login(user);
            session.setAttribute("usuarioLogado", user);
            return new HomeView(null);
        } catch (BusinessRuleException e) {
            return viewWithMessage(user, e.getMessage());
        }
    }

    @GetMapping("/logoff")
    public ModelAndView logOff(HttpSession session) {
        session.setAttribute("usuarioLogado", null);

        return viewWithoutMessage(new UserModel());
    }


    private LoginView viewWithoutMessage(UserModel user) {
        return viewWithMessage(user, null);
    }

    private LoginView viewWithMessage(UserModel user, String message) {
        return new LoginView(user,message);
    }
}
