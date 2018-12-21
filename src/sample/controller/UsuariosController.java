package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import jfxOptionPane.application.JFXOptionPane;
import sample.MainApp;
import sample.model.DAO.UserDAO;
import sample.model.bean.Session;
import sample.model.bean.Usuario;
import sun.applet.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuariosController implements Initializable {

    @FXML TableView<Usuario> userTable = new TableView<>();
    @FXML TableColumn<Usuario, Integer> userTableID = new TableColumn<>();
    @FXML TableColumn<Usuario, String> userTableNome= new TableColumn<>();
    @FXML TableColumn<Usuario, String> userTableLogin= new TableColumn<>();
    @FXML TableColumn<Usuario, String> userTableCargo= new TableColumn<>();

    @FXML HBox hBoxFormOne = new HBox();
    @FXML HBox hBoxFormTwo = new HBox();
    @FXML HBox hBoxFormButtons = new HBox();
    @FXML HBox hBoxAddUser = new HBox();

    @FXML JFXButton addUserButton = new JFXButton();
    @FXML JFXButton userBtnCancelar = new JFXButton();
    @FXML JFXButton userBtnSalvar = new JFXButton();
    @FXML JFXButton userDeleteButton = new JFXButton();

    @FXML JFXComboBox<String> userTxtCargo = new JFXComboBox<>();
    @FXML JFXTextField userTxtNome = new JFXTextField();
    @FXML JFXTextField userTxtLogin = new JFXTextField();
    @FXML JFXPasswordField userTxtSenha = new JFXPasswordField();
    @FXML JFXPasswordField userTxtConfSenha = new JFXPasswordField();

    ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
    ObservableList<String> cargos = FXCollections.observableArrayList();

    JFXOptionPane optionPane = new JFXOptionPane(MainApp.getStage());

    @FXML
    public void addNewUser(ActionEvent event) {

        if(Session.getUserCargo().equals("Administrador")) {

            hBoxFormOne.setDisable(false);
            hBoxFormTwo.setDisable(false);
            hBoxFormButtons.setDisable(false);
            hBoxAddUser.setDisable(true);

        } else {
            optionPane.showMessageDialog("Somente administradores podem adicionar novos usuário!");
        }

    }

    @FXML
    public void cancelarAddAction(ActionEvent event) {

        this.clearAddUserForm();

    }

    @FXML
    public void salvarAddAction(ActionEvent event) {



        if(userTxtSenha.getText().equals(userTxtConfSenha.getText())) {

            Usuario user = new Usuario();
            UserDAO userDAO = new UserDAO();

            user.setNome(userTxtNome.getText());
            user.setLogin(userTxtLogin.getText());
            user.setSenha(userTxtSenha.getText());
            user.setCargo(userTxtCargo.getSelectionModel().getSelectedItem());

            userDAO.create(user);

            this.clearAddUserForm();
            this.update();

        } else {
            optionPane.showMessageDialog("As senhas não são iguais!");
        }

    }

    @FXML
    public void deleteUserAction(ActionEvent event) {

        if(Session.getUserCargo().equals("Administrador")) {

            if(userTable.getSelectionModel().getSelectedItem() != null) {

                UserDAO userDAO = new UserDAO();
                Usuario usuario = userTable.getSelectionModel().getSelectedItem();
                if(optionPane.showConfirmDialog("Tem certeza que quer excluir "+usuario.getNome()+" do sistema?")) {

                    userDAO.delete(usuario);
                    this.update();

                }

            } else {
                optionPane.showMessageDialog("Selecione um usuário primeiro!");
            }
        } else {
            optionPane.showMessageDialog("Somente administradores podem excluir usuários!");
        }

    }

    public void update() {

        userTable.getItems().clear();
        UserDAO userDAO = new UserDAO();
        usuarios.addAll(userDAO.listUsers());
        userTable.setItems(usuarios);

    }

    public void clearAddUserForm() {
        userTxtNome.clear();
        userTxtLogin.clear();
        userTxtSenha.clear();
        userTxtConfSenha.clear();
        userTxtCargo.getSelectionModel().clearSelection();

        hBoxFormOne.setDisable(true);
        hBoxFormTwo.setDisable(true);
        hBoxFormButtons.setDisable(true);
        hBoxAddUser.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        hBoxFormOne.setDisable(true);
        hBoxFormTwo.setDisable(true);
        hBoxFormButtons.setDisable(true);

        userTableID.setCellValueFactory(new PropertyValueFactory<>("id"));
        userTableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        userTableLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        userTableCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

        this.update();

        cargos.addAll(
            "Administrador",
            "Professor",
            "Gerente",
            "Auxiliar Administrativo"
        );

        userTxtCargo.setItems(cargos);

    }



}
