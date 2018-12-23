package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Responsavel;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * hover-academic
 * Class DAO of responsavel
 * @author hover
 */
public class ResponsavelDAO {

    //create a new Responsavel
    public void create(Responsavel responsavel) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("INSERT INTO responsavel (nome, data_nascimento, rg, cpf) values (?,?,?,?)");
            statement.setString(1, responsavel.getNome());
            statement.setString(2, responsavel.getDataNascimento());
            statement.setString(3, responsavel.getRg());
            statement.setString(4, responsavel.getCpf());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //list all the responsaveis of the system
    public List<Responsavel> listResponsavel() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Responsavel> responsaveis = new ArrayList<>();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM responsavel");
            result = statement.executeQuery();

            while(result.next()) {

                Responsavel responsavel = new Responsavel(
                        result.getInt("id_responsavel"),
                        result.getString("nome"),
                        result.getString("data_nascimento"),
                        result.getString("rg"),
                        result.getString("cpf")
                );
                responsaveis.add(responsavel);
            }


        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return responsaveis;
    }

    //delete a responsavel from the system
    public void delete(Responsavel responsavel) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("DELETE FROM responsavel WHERE id_responsavel = ?");
            statement.setInt(1, responsavel.getId());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //select a responsavel by id
    public Responsavel selectById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Responsavel responsavel = new Responsavel();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM responsavel WHERE id_responsavel = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                responsavel.setId(result.getInt("id_responsavel"));
                responsavel.setNome(result.getString("nome"));
                responsavel.setDataNascimento(result.getString("data_nascimento"));
                responsavel.setRg(result.getString("rg"));
                responsavel.setCpf(result.getString("cpf"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao buscar!"+ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return responsavel;
    }
}
