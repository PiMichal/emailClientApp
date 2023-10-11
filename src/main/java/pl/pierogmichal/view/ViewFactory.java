package pl.pierogmichal.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pierogmichal.EmailManager;
import pl.pierogmichal.controller.*;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {
    private EmailManager emailManager;
    private ArrayList<Stage> actionStages;
    private boolean mainViewInitialized = false;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        actionStages = new ArrayList<Stage>();
    }
    public boolean isMainViewInitialized() {
        return mainViewInitialized;
    }
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void showLoginWindow(){

        BaseController controller = new LoginWindowController(emailManager, this, "/layout/LoginWindow.fxml");

        initializeStage(controller);

    }
    public void showEmailDetailsWindow() {
        BaseController controller = new EmailDetailsController(emailManager, this, "/layout/EmailDetailsWindow.fxml");
        initializeStage(controller);
    }
    public void showMainWindow(){

        BaseController controller = new MainWindowController(emailManager, this, "/layout/MainWindow.fxml");

        initializeStage(controller);
        mainViewInitialized = true;
    }

    public void showOptionsWindow(){
        BaseController controller = new OptionsWindowController(emailManager, this, "/layout/OptionsWindow.fxml");

        initializeStage(controller);
    }

    public void showComposeMessageWindow(){
        BaseController controller = new ComposeMessageController(emailManager, this, "/layout/ComposeMessageWindow.fxml");

        initializeStage(controller);
    }

    private void initializeStage(BaseController baseController) {
        FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fmxlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fmxlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        updateStyle(scene);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        actionStages.add(stage);
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
        actionStages.remove(stageToClose);
    }

    public void updateAllStyles() {
        for (Stage stage : actionStages) {
            Scene scene = stage.getScene();
            updateStyle(scene);
        }
    }
    private void updateStyle(Scene scene){
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
        scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
    }
}
