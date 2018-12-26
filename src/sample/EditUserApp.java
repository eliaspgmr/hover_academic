package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.model.bean.Usuario;

import java.io.IOException;

public class EditUserApp {

    public EditUserApp(Stage stageOwner, Usuario usuario) throws IOException {

        editUserStage = new Stage();
        this.usuario = usuario;
        Parent editUser = FXMLLoader.load(getClass().getResource("view/EditUser.fxml"));
        editUserStage.setTitle("Editar Usuário");
        editUserStage.setWidth(582);
        editUserStage.setHeight(367);
        editUserStage.setResizable(false);
        editUserStage.initOwner(stageOwner);
        editUserStage.initModality(Modality.APPLICATION_MODAL);

        editUserStage.setScene(new Scene(editUser));
        editUserStage.showAndWait();

    }

    static Stage editUserStage;
    static Usuario usuario;

    public static Stage getStage() {
        return editUserStage;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

}
