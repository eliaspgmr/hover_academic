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

public class MainApp extends Application {
    //Main Stage
    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        mainStage = primaryStage;
        mainStage.setTitle("Hover-Academic");
        mainStage.setScene(new Scene(root));

        ServerSession.update();
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
