package br.uem.iss.anesthesia.view;

public class HomeView extends AbstractModelAndView {

    public HomeView(String message) {
        super("home");
        this.addObject("message", message);
    }
}
