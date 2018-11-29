package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Node;
import javafx.stage.Stage;
import sample.model.bean.Session;
import sample.Application.ConfigApp;
import sample.Application.MainApp;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import sample.criptography.Criptography;
import sample.Application.LoginApp;
import sample.model.DAO.UserDAO;
import sample.model.bean.Usuario;



public class LoginController {
    
    @FXML ImageView btnConfig = new ImageView();
    @FXML ImageView btnClose = new ImageView();
    @FXML JFXTextField txtLogin = new JFXTextField();
    @FXML JFXPasswordField txtPassword = new JFXPasswordField();
    @FXML JFXButton btnLogin = new JFXButton();

    double x = 0;
    double y = 0;
    
    @FXML 
    public void btnConfigAction () throws IOException {

        new ConfigApp(LoginApp.getLoginStage());

    }
    
    @FXML
    public void close(){
        LoginApp.getLoginStage().close();
    }
    
    @FXML
    public void login(ActionEvent evt) throws IOException {

        UserDAO userDAO = new UserDAO();
        Usuario user = userDAO.select(txtLogin.getText());

        if(user.getLogin() == null) {
            System.out.println("Usuário Inválido!");
        }else if(Criptography.enc(txtPassword.getText()).equals(user.getSenha())){

            Session.start(user);

            txtLogin.setText(null);
            txtPassword.setText(null);
            LoginApp.getLoginStage().close();
            new MainApp();

        }else{
            System.out.println("Senha Inválida!");
        }

    }

    @FXML
    public void dragged(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    public void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
}
