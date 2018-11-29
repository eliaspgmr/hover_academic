package sample.model.DAO;
/**
 * hover-academic
 * Class DAO of user
 * @author hover
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sample.connection.ConnectionHover;
import sample.model.bean.Usuario;
import sample.criptography.Criptography;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDAO {

    //Create a new User on system
    public void create(Usuario user) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("INSERT INTO usuarios (nome, login, senha, cargo) VALUES (?,?,?,?)");
            statement.setString(1, user.getNome());
            statement.setString(2, user.getLogin());
            statement.setString(3, Criptography.enc( user.getSenha()));
            statement.setString(4, user.getCargo());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //List all the users of the system
    public List<Usuario> listUsers() {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {

            statement = connection.prepareStatement("SELECT * FROM usuarios");
            result = statement.executeQuery();

            while(result.next()) {

                Usuario usuario = new Usuario(
                        result.getInt("id_usuario"),
                        result.getString("nome"),
                        result.getString("login"),
                        result.getString("senha"),
                        result.getString("cargo")
                );
                usuarios.add(usuario);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return usuarios;
    }

    //Delete a specific user
    public void delete(Usuario user) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ?");
            statement.setInt(1, user.getId());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Select user by login
    public Usuario select(String login) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        Usuario user = new Usuario();

        try {

            statement = connection.prepareStatement("SELECT * FROM usuarios WHERE login = ?");
            statement.setString(1, login);
            result = statement.executeQuery();

            if(result.next()) {

                user.setId(result.getInt("id_usuario"));
                user.setNome(result.getString("nome"));
                user.setLogin(result.getString("login"));
                user.setSenha(result.getString("senha"));
                user.setCargo(result.getString("cargo"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return user;
    }

    public Usuario selectById(int id) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        Usuario user = new Usuario();

        try {

            statement = connection.prepareStatement("SELECT * FROM usuarios WHERE id_user = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                user.setId(result.getInt("id_usuario"));
                user.setNome(result.getString("nome"));
                user.setLogin(result.getString("login"));
                user.setSenha(result.getString("senha"));
                user.setCargo(result.getString("cargo"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return user;
    }


}