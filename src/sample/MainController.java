package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jfxOptionPane.application.JFXOptionPane;
import sample.model.bean.Session;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML Label txtNome = new Label();
    @FXML Label txtTitulo = new Label();
    @FXML ImageView btnClose = new ImageView();
    @FXML AnchorPane contentField = new AnchorPane();
    @FXML Button btnAlunos = new Button();
    @FXML Button btnFinanceiro = new Button();
    @FXML Button btnRelatorios = new Button();
    @FXML Button btnUsuarios = new Button();
    @FXML Button btnConfig = new Button();

    JFXOptionPane optionPane = new JFXOptionPane(MainApp.getStage());

    @FXML
    public void close() {

        if(optionPane.showConfirmDialog("Deseja mesmo sair?")) {
            MainApp.getStage().close();
            Platform.exit();
            System.exit(0);
        }

    }

    @FXML
    public void logoff() throws Exception {

        Session.close();
        MainApp.getStage().close();
        new LoginApp().start(new Stage());

        //LoginApp.getLoginStage().show();

    }

    @FXML
    public void loadAlunos(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("view/Alunos.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);
            txtTitulo.setText("Alunos");

        } catch (IOException e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }



    @FXML
    public void loadFinanceiro(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("view/Financeiro.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);
            txtTitulo.setText("Financeiro");

        } catch (IOException e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }

    @FXML
    public void loadRelatorios (ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("view/Relatorios.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);
            txtTitulo.setText("Relatórios");

        } catch (IOException e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }

    @FXML
    public void loadUsuarios (ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("view/Usuarios.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);
            txtTitulo.setText("Usuários");

        } catch (IOException e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }

    @FXML
    public void loadConfig (ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("view/Configuracoes.fxml"));
            contentField.getChildren().clear();
            contentField.getChildren().add(root);
            txtTitulo.setText("Configurações");

        } catch (IOException e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtNome.setText(Session.getUserName());
        this.loadAlunos(new ActionEvent());
        txtTitulo.setText("Alunos");
    }
}
