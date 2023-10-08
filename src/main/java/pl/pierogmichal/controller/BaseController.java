package pl.pierogmichal.controller;

import pl.pierogmichal.EmailManager;
import pl.pierogmichal.view.ViewFactory;

public abstract class BaseController {
    protected EmailManager emailManager;
    protected ViewFactory viewFactory;
    private String fxmlName;

    protected BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
