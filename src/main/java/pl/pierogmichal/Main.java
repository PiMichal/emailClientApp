package pl.pierogmichal;


import javafx.application.Application;
import javafx.stage.Stage;
import pl.pierogmichal.controller.persistence.PersistenceAccess;
import pl.pierogmichal.controller.persistence.ValidAccount;
import pl.pierogmichal.controller.services.LoginService;
import pl.pierogmichal.model.EmailAccount;
import pl.pierogmichal.view.ViewFactory;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private PersistenceAccess persistenceAccess = new PersistenceAccess();
    private EmailManager emailManager = new EmailManager();

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(emailManager);
        List<ValidAccount> validAccountList = persistenceAccess.loadFromPersistence();
        if (validAccountList.size() > 0) {
            viewFactory.showMainWindow();
            for (ValidAccount validAccount: validAccountList){
                EmailAccount emailAccount = new EmailAccount(validAccount.getAddress(), validAccount.getPassword());
                LoginService loginService = new LoginService(emailAccount, emailManager);
                loginService.start();
            }
        } else {
            viewFactory.showLoginWindow();
        }
    }

    @Override
    public void stop() throws Exception {
        List<ValidAccount> validAccounts = new ArrayList<>();
        for (EmailAccount emailAccount: emailManager.getEmailAccounts()) {
            validAccounts.add(new ValidAccount(emailAccount.getAddress(), emailAccount.getPassword()));
        }
        persistenceAccess.saveToPersistence(validAccounts);
    }
}