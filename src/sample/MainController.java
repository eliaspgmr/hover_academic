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
    @FXML Label txtCargo = new Label();
    @FXML Label txtTitulo = new Label();
    @FXML ImageView btnClose = new ImageView();
    @FXML AnchorPane contentField = new AnchorPane();
    @FXML Button btnAlunos = new Button();
    @FXML Button btnFinanceiro = new Button();
    @FXML Button btnRelatorios = new Button();
    @FXML Button btnUsuarios = new Button();
    @FXML Button btnConfig = new Button();

    private Parent userRoot;
    private Parent configRoot;
    private Parent alunoRoot;
    private Parent relatorioRoot;
    private Parent financeiroRoot;

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

            contentField.getChildren().clear();
            contentField.getChildren().add(alunoRoot);
            txtTitulo.setText("Alunos");

        } catch (Exception e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }



    @FXML
    public void loadFinanceiro(ActionEvent event) {
        try {

            contentField.getChildren().clear();
            contentField.getChildren().add(financeiroRoot);
            txtTitulo.setText("Financeiro");

        } catch (Exception e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }

    @FXML
    public void loadRelatorios (ActionEvent event) {
        try {

            contentField.getChildren().clear();
            contentField.getChildren().add(relatorioRoot);
            txtTitulo.setText("Relatórios");

        } catch (Exception e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }

    @FXML
    public void loadUsuarios (ActionEvent event) {
        try {

            contentField.getChildren().clear();
            contentField.getChildren().add(userRoot);
            txtTitulo.setText("Usuários");

        } catch (Exception e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }

    @FXML
    public void loadConfig (ActionEvent event) {

        try {

            contentField.getChildren().clear();
            contentField.getChildren().add(configRoot);
            txtTitulo.setText("Configurações");

        } catch (Exception e) {
            optionPane.showErrorDialog(e.getMessage());
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            alunoRoot = FXMLLoader.load(getClass().getResource("view/Alunos.fxml"));
            financeiroRoot = FXMLLoader.load(getClass().getResource("view/Financeiro.fxml"));
            relatorioRoot = FXMLLoader.load(getClass().getResource("view/Relatorios.fxml"));
            userRoot = FXMLLoader.load(getClass().getResource("view/Usuarios.fxml"));
            configRoot = FXMLLoader.load(getClass().getResource("view/Configuracoes.fxml"));

        } catch (IOException e) {
            optionPane.showErrorDialog("Os FXML files não podem ser carregados!");
        }

        txtNome.setText(Session.getUserName());
        txtCargo.setText("("+Session.getUserCargo()+")");
        this.loadAlunos(new ActionEvent());
        txtTitulo.setText("Alunos");
    }
}
