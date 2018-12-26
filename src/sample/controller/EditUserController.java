package sample.controller;

import com.jfoenix.controls.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import jfxOptionPane.application.JFXOptionPane;
import sample.EditUserApp;
import sample.model.DAO.UserDAO;
import sample.model.bean.Session;
import sample.model.bean.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class EditUserController implements Initializable {

    @FXML JFXTextField editUserName = new JFXTextField();
    @FXML JFXTextField editUserLogin = new JFXTextField();
    @FXML JFXComboBox<String> editUserCargo = new JFXComboBox<>();
    @FXML JFXPasswordField editUserSenha = new JFXPasswordField();
    @FXML JFXPasswordField editUserConfSenha = new JFXPasswordField();
    @FXML JFXCheckBox editUserSenhaSelect = new JFXCheckBox();
    @FXML JFXButton editUserSalvar = new JFXButton();
    @FXML JFXButton editUserCancelar = new JFXButton();
    @FXML VBox editUserSenhaBox = new VBox();
    @FXML VBox editUserBox = new VBox();

    Usuario usuario = new Usuario();
    Usuario novoUsuario = new Usuario();
    UserDAO userDAO = new UserDAO();
    ObservableList<String> cargos = FXCollections.observableArrayList();
    JFXOptionPane optionPane = new JFXOptionPane(EditUserApp.getStage());

    @FXML
    public void editUserSalvarAction(ActionEvent event) {
        novoUsuario.setId(usuario.getId());

        if(editUserSenhaSelect.selectedProperty().getValue()) {

            if(editUserSenha.getText().equals(editUserConfSenha.getText())) {

                novoUsuario.setSenha(editUserSenha.getText());
                if(userDAO.updatePassword(novoUsuario)) {

                    optionPane.showMessageDialog("Senha alterada com sucesso!");
                    EditUserApp.getStage().close();

                } else {
                    optionPane.showMessageDialog(userDAO.getMessage());
                }

            } else {
                optionPane.showMessageDialog("As senhas são diferentes");
            }

        } else {


            if(!editUserName.getText().equals(usuario.getNome()) ||
                    !editUserLogin.getText().equals(usuario.getLogin()) ||
                    !editUserCargo.getSelectionModel().getSelectedItem().equals(usuario.getCargo())){

                novoUsuario.setNome(editUserName.getText());
                novoUsuario.setLogin(editUserLogin.getText());
                novoUsuario.setCargo(editUserCargo.getSelectionModel().getSelectedItem());

                if(userDAO.updateUser(novoUsuario)) {

                    optionPane.showMessageDialog("Salvo com sucesso!");
                    EditUserApp.getStage().close();

                } else {
                    optionPane.showMessageDialog(userDAO.getMessage());
                }


            } else if(editUserSenhaSelect.selectedProperty().getValue()) {

            } else {
                optionPane.showMessageDialog("Nenhuma alteração encontrada!");
            }

        }

    }

    @FXML
    public void editUserCancelarAction(ActionEvent event) {

        EditUserApp.getStage().close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        usuario = EditUserApp.getUsuario();
        cargos.addAll(
                "Administrador",
                "Professor",
                "Gerente",
                "Auxiliar Administrativo"
        );
        editUserCargo.setItems(cargos);

        updateUserForm();

        editUserSenhaBox.setDisable(true);
        editUserBox.setDisable(false);

        if(usuario.getLogin().equals("root")) {
            editUserLogin.setDisable(true);
            editUserCargo.setDisable(true);
        }

        editUserSenhaSelect.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                enablePasswordBox();
            }
        });

    }

    public void enablePasswordBox() {
        if(editUserSenhaSelect.selectedProperty().getValue()) {
            editUserSenhaBox.setDisable(false);
            updateUserForm();
            editUserBox.setDisable(true);
        } else {
            editUserSenha.clear();
            editUserConfSenha.clear();
            editUserSenhaBox.setDisable(true);
            editUserBox.setDisable(false);
        }
    }

    public void updateUserForm() {

        editUserName.setText(usuario.getNome());
        editUserLogin.setText(usuario.getLogin());

        switch (usuario.getCargo()) {
            case "Administrador":
                editUserCargo.getSelectionModel().select(0);
                break;
            case "Professor":
                editUserCargo.getSelectionModel().select(1);
                break;
            case "Gerente":
                editUserCargo.getSelectionModel().select(2);
                break;
            case "Auxiliar Administrativo":
                editUserCargo.getSelectionModel().select(3);
                break;
        }

    }

}
