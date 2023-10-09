package pl.pierogmichal;

import javafx.scene.control.TreeItem;
import pl.pierogmichal.controller.services.FetchFoldersSerivce;
import pl.pierogmichal.model.EmailAccount;
import pl.pierogmichal.model.EmailTreeItem;

public class EmailManager {

    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount) {
        EmailTreeItem<String> treeItem = new EmailTreeItem<>(emailAccount.getAddress());
        FetchFoldersSerivce fetchFoldersSerivce = new FetchFoldersSerivce(emailAccount.getStore(), treeItem);
        fetchFoldersSerivce.start();

        foldersRoot.getChildren().add(treeItem);
    }
}
