package sample.view;

/*
* Hover Academic
* Main class
* @author: Hover
*/

//imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.bean.ServerSession;

import java.io.IOException;

public class MainApp {
    //Main Stage
    private static Stage mainStage = new Stage();

    public MainApp() throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        mainStage.setTitle("Hover-Academic");
        mainStage.setScene(new Scene(root));
        mainStage.show();

    }



    //Method to get the main stage
    public static Stage getStage() {
        return mainStage;
    }


    
}
