/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.bean.ServerSession;

/**
 *
 * @author Elias Ferreira
 */
public class LoginApp extends Application {
    static Stage loginStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
        loginStage = primaryStage;
        loginStage.setScene(new Scene(root));
        loginStage.initStyle(StageStyle.UNDECORATED);
        loginStage.show();

        ServerSession.update();
    }


    
    public static Stage getLoginStage() {
        return loginStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
