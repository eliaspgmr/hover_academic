/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Elias Ferreira
 */
public class LoginApp {
    
    public LoginApp() throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        loginStage.setScene(new Scene(root));
        loginStage.initStyle(StageStyle.UNDECORATED);
        loginStage.show();
        
    }
    
    static Stage loginStage = new Stage();
    
    public static Stage getLoginStage() {
        return loginStage;
    }
    
}
