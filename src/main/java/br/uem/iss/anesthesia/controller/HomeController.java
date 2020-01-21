package br.uem.iss.anesthesia.controller;

import br.uem.iss.anesthesia.model.entity.UserModel;
import br.uem.iss.anesthesia.view.HomeView;
import br.uem.iss.anesthesia.view.LoginView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping
    public ModelAndView home(HttpSession session) {
        UserModel userLogado = (UserModel) session.getAttribute("usuarioLogado");

        if (userLogado == null)
            return new LoginView(new UserModel(),null);

        return new HomeView(null);
    }
}
