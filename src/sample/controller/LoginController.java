package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import sample.model.bean.Session;
import sample.view.ConfigApp;
import sample.view.MainApp;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import sample.criptography.Criptography;
import sample.view.LoginApp;
import sample.model.DAO.UserDAO;
import sample.model.bean.Usuario;



public class LoginController {
    
    @FXML ImageView btnConfig = new ImageView();
    @FXML ImageView btnClose = new ImageView();
    @FXML JFXTextField txtLogin = new JFXTextField();
    @FXML JFXPasswordField txtPassword = new JFXPasswordField();
    @FXML JFXButton btnLogin = new JFXButton();
    
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
    
}
