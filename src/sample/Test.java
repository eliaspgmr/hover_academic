package sample;

import sample.connection.ConnectionHover;
import sample.model.Criptography;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String args[]) {


            Connection connection = ConnectionHover.getConnection();
            PreparedStatement statement = null;

            try {

                statement = connection.prepareStatement("INSERT INTO usuarios (nome, login, senha, cargo) VALUES (?,?,?,?)");
                statement.setString(1, "Elias Ferreira");
                statement.setString(2, "elias");
                statement.setString(3, "arkanjo45");
                statement.setString(4, "professor");

                statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Salvo com sucesso");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
            } finally {
                ConnectionHover.closeConnection(connection, statement);
            }



    }
}
