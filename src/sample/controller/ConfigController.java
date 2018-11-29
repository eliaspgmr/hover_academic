package sample.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import sample.config.RWConfig;
import sample.model.bean.Config;
import sample.model.bean.ServerSession;
import sample.Application.ConfigApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class ConfigController implements Initializable{
    
    @FXML JFXTextField txtUser = new JFXTextField();
    @FXML JFXPasswordField txtPass = new JFXPasswordField();
    @FXML JFXTextField txtServer = new JFXTextField();
    @FXML JFXTextField txtPort = new JFXTextField();
    
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
                ConfigApp.getStage().close();
            }else {
                System.out.println("Problema ao salvar dados");
            }
            
        }else {
            System.out.println("The file config couldn't been created!");
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RWConfig.createFile();
        Config config = RWConfig.read();
        txtUser.setText(config.getUser());
        txtPass.setText(config.getPassword());
        txtServer.setText(config.getServer());
        txtPort.setText(config.getPort());
    }

}
