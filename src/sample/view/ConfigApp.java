package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class ConfigApp {
    
    public ConfigApp(Stage stageOwner) throws IOException {
        
        Parent configRoot = FXMLLoader.load(getClass().getResource("Config.fxml"));
        configStage = new Stage();
        configStage.setTitle("Config");
        configStage.setWidth(287);
        configStage.setHeight(342);
        configStage.setResizable(false);
        configStage.initOwner(stageOwner);
        configStage.initModality(Modality.APPLICATION_MODAL);

        configStage.setScene(new Scene(configRoot));
        configStage.show();
        
    }

    static Stage configStage;
    
    public static Stage getStage() {
        return configStage;
    }

}
