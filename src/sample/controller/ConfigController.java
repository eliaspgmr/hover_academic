package sample.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import sample.model.RWConfig;
import sample.view.ConfigApp;
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
        
        String[] dados = new String[4];
        dados[0] = txtUser.getText();
        dados[1] = txtPass.getText();
        dados[2] = txtServer.getText();
        dados[3] = txtPort.getText();

        RWConfig.createFile();
        if(RWConfig.getCreateValue()) { 
            
            RWConfig.write(dados);
            if(RWConfig.getWriteValue()) {
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
        String[] dados = RWConfig.read();
        txtUser.setText(dados[0]);
        txtPass.setText(dados[1]);
        txtServer.setText(dados[2]);
        txtPort.setText(dados[3]);
    }

}
