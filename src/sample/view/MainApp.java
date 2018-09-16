package sample.view;

/*
* Market
* Main class
* @author: Elias Ferreira
*/

//imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    //Main Stage
    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        mainStage = primaryStage;
        mainStage.setTitle("Market");
        mainStage.setScene(new Scene(root));
        
        new LoginApp();

    }
    
    //Method to get the main stage
    public static Stage getStage() {
        return mainStage;
    }

    //Main method
    public static void main(String[] args) {
        launch(args);
    }
    
}
