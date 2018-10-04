package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import sample.model.bean.Session;
import sample.view.LoginApp;
import sample.view.MainApp;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML Label txtNome = new Label();
    @FXML ImageView btnClose = new ImageView();

    @FXML
    public void close() {
        MainApp.getStage().close();
    }

    @FXML
    public void logoff() {
        Session.close();
        MainApp.getStage().close();
        LoginApp.getLoginStage().show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtNome.setText(Session.getUserLogin());
    }
}
