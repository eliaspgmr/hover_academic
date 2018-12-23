package sample.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import jfxOptionPane.application.JFXOptionPane;
import sample.LoginApp;
import sample.config.RWConfig;
import sample.model.bean.Config;
import sample.model.bean.ServerSession;
import sample.ConfigApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class ConfigController implements Initializable{

    //nodes
    @FXML JFXTextField txtUser = new JFXTextField();
    @FXML JFXPasswordField txtPass = new JFXPasswordField();
    @FXML JFXTextField txtServer = new JFXTextField();
    @FXML JFXTextField txtPort = new JFXTextField();

    //Global Variables
    JFXOptionPane optionPane = new JFXOptionPane(LoginApp.getLoginStage());
    
    @FXML
    public void close() { 
        ConfigApp.getStage().close(); 
    }

    @FXML
    public void save() {
        
        Config dados = new Config();
        dados.setUser(txtUser.getText());
        dados.setPassword(txtPass.getText());
        dados.setServer(txtServer.getText());
        dados.setPort(txtPort.getText());

        RWConfig.createFile();


        if(RWConfig.getCreateValue()) {

            RWConfig.write(dados);
            if(RWConfig.getWriteValue()) {
                ServerSession.update();
                optionPane.showMessageDialog("Salvo","Servidor salvo com sucesso!");
                ConfigApp.getStage().close();
            }else {
                optionPane.showErrorDialog("Problema ao salvar dados");
            }

        }else {
            optionPane.showErrorDialog("Problema ao criar arquivo config.ini!");
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RWConfig.createFile();
        if(RWConfig.getCreateValue()) {
            Config config = RWConfig.read();
            if(RWConfig.getReadValue()) {

                txtUser.setText(config.getUser());
                txtPass.setText(config.getPassword());
                txtServer.setText(config.getServer());
                txtPort.setText(config.getPort());

            } else {
                optionPane.showErrorDialog("Problema ao ler dados");
            }

        } else {
            optionPane.showErrorDialog("Problema ao criar arquivo config.ini!");
        }

    }

}
