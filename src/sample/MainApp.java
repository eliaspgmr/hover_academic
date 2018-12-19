package sample;

/*
* Hover Academic
* Main class
* @author: Hover
*/

//imports
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jfxOptionPane.application.JFXOptionPane;

import java.io.IOException;

public class MainApp {
    //Main Stage
    private static Stage mainStage = new Stage();
    JFXOptionPane optionPane = new JFXOptionPane(mainStage);

    public MainApp() throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
        mainStage.setTitle("Hover-Academic");
        mainStage.setScene(new Scene(root));
        mainStage.show();

        mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                t.consume();

                if(optionPane.showConfirmDialog("Deseja mesmo sair?")) {
                    mainStage.close();
                    Platform.exit();
                    System.exit(0);
                }

            }
        });

    }



    //Method to get the main stage
    public static Stage getStage() {
        return mainStage;
    }


    
}
