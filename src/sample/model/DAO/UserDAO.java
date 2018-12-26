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
import sample.connection.ConnectionHover;
import sample.interfaces.UserDAOInterface;
import sample.model.bean.Usuario;
import sample.criptography.Criptography;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDAO implements UserDAOInterface {

    //Global Variables
    private String message;
    private boolean operationValue;

    @Override //Create a new User on the system
    public boolean create(Usuario user) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("INSERT INTO usuarios (us_nome, us_login, us_senha, us_cargo) VALUES (?,?,?,?)");
            statement.setString(1, user.getNome());
            statement.setString(2, user.getLogin());
            statement.setString(3, Criptography.enc( user.getSenha()));
            statement.setString(4, user.getCargo());

            statement.executeUpdate();

            this.message = "Salvo com sucesso";
            return true;

        } catch (SQLException ex) {
            this.message = "Problema ao salvar!\n"+ex.getMessage();
            return false;
        } catch (ClassNotFoundException e) {
            this.message = "Problema no driver de conexão\n"+e.getMessage();
            return false;
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Delete a specific user
    @Override
    public boolean delete(Usuario user) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ?");
            statement.setInt(1, user.getId());


            statement.executeUpdate();

            this.message = "Excluído com sucesso!";
            return true;

        } catch (SQLException ex) {
            this.message = "Problema ao excluir!\n " +ex.getMessage();
            return false;
        } catch (ClassNotFoundException e) {
            this.message = "Problema no driver de conexão!\n " +e.getMessage();
            return false;
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //List all the users of the system
    @Override
    public List<Usuario> listUsers() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM usuarios ORDER BY us_nome");
            result = statement.executeQuery();

            while(result.next()) {

                Usuario usuario = new Usuario(
                        result.getInt("id_usuario"),
                        result.getString("us_nome"),
                        result.getString("us_login"),
                        result.getString("us_senha"),
                        result.getString("us_cargo")
                );
                usuarios.add(usuario);

            }

            this.operationValue = true;

        } catch (SQLException ex) {
            this.operationValue = false;
            this.message = "Problema ao acessar usuários!\n " +ex.getMessage();
        } catch (ClassNotFoundException e) {
            this.operationValue = false;
            this.message = "Problema no driver de conexão!\n " +e.getMessage();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return usuarios;
    }

    //Select user by login
    @Override
    public Usuario select(String login) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Usuario user = new Usuario();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM usuarios WHERE us_login = ?");
            statement.setString(1, login);
            result = statement.executeQuery();

            if(result.next()) {

                user.setId(result.getInt("id_usuario"));
                user.setNome(result.getString("us_nome"));
                user.setLogin(result.getString("us_login"));
                user.setSenha(result.getString("us_senha"));
                user.setCargo(result.getString("us_cargo"));

            }

            this.operationValue = true;

        } catch (SQLException ex) {
            this.operationValue = false;
            this.message = "Problema ao acessar usuários!\n " +ex.getMessage();
        } catch (ClassNotFoundException e) {
            this.operationValue = false;
            this.message = "Problema no driver de conexão!\n " +e.getMessage();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return user;
    }

    //Select user by login
    @Override
    public List<Usuario> find(String field, String login) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM usuarios WHERE "+field+" like ? ORDER BY us_nome");

            //statement.setString(1, field);
            statement.setString(1, login+"%");
            result = statement.executeQuery();

            while(result.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(result.getInt("id_usuario"));
                usuario.setNome(result.getString("us_nome"));
                usuario.setLogin(result.getString("us_login"));
                usuario.setSenha(result.getString("us_senha"));
                usuario.setCargo(result.getString("us_cargo"));

                usuarios.add(usuario);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return usuarios;
    }

    //select a user by his ID
    @Override
    public Usuario selectById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Usuario user = new Usuario();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM usuarios WHERE id_user = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                user.setId(result.getInt("id_usuario"));
                user.setNome(result.getString("us_nome"));
                user.setLogin(result.getString("us_login"));
                user.setSenha(result.getString("us_senha"));
                user.setCargo(result.getString("us_cargo"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return user;
    }

    @Override
    public boolean updateUser(Usuario usuario) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("UPDATE usuarios SET us_nome = ?, us_login = ?, us_cargo = ? WHERE id_usuario = ?");
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getCargo());
            statement.setInt(4, usuario.getId());

            statement.executeUpdate();

            this.message = "Salvo com sucesso";
            return true;

        } catch (SQLException ex) {
            this.message = "Problema ao salvar!\n"+ex.getMessage();
            return false;
        } catch (ClassNotFoundException e) {
            this.message = "Problema no driver de conexão\n"+e.getMessage();
            return false;
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    @Override
    public boolean updatePassword(Usuario usuario) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("UPDATE usuarios SET us_senha = ? WHERE id_usuario = ?");
            statement.setString(1, Criptography.enc(usuario.getSenha()));
            statement.setInt(2, usuario.getId());

            statement.executeUpdate();

            this.message = "Salvo com sucesso";
            return true;

        } catch (SQLException ex) {
            this.message = "Problema ao salvar!\n"+ex.getMessage();
            return false;
        } catch (ClassNotFoundException e) {
            this.message = "Problema no driver de conexão\n"+e.getMessage();
            return false;
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }


    public String getMessage() {
        return message;
    }

    public boolean isOperationValue() {
        return operationValue;
    }

}