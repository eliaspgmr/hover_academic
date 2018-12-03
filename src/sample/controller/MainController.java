package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.model.bean.Session;
import sample.Application.LoginApp;
import sample.Application.MainApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML Label txtNome = new Label();
    @FXML ImageView btnClose = new ImageView();
    @FXML AnchorPane contentField = new AnchorPane();
    @FXML Button btnAlunos = new Button();
    @FXML Button btnFinanceiro = new Button();
    @FXML Button btnRelatorios = new Button();
    @FXML Button btnUsuarios = new Button();
    @FXML Button btnConfig = new Button();

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

    @FXML
    public void loadAlunos(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../view/Alunos.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void loadFinanceiro(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../view/Financeiro.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void loadRelatorios (ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../view/Relatorios.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void loadUsuarios (ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../view/Usuarios.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void loadConfig (ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../view/Configuracao.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtNome.setText(Session.getUserLogin());
        this.loadAlunos(new ActionEvent());
    }
}
