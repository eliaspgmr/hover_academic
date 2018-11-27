package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Responsavel;

import javax.swing.*;
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

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO responsavel (nome, data_nascimento, rg, cpf) values (?,?,?,?)");
            statement.setString(1, responsavel.getNome());
            statement.setString(2, responsavel.getDataNascimento());
            statement.setString(3, responsavel.getRg());
            statement.setString(4, responsavel.getCpf());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //list all the responsaveis of the system
    public List<Responsavel> listResponsavel() {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Responsavel> responsavelList = new ArrayList<>();

        try {

            statement = connection.prepareStatement("SELECT * FROM responsavel");
            resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Responsavel responsavel = new Responsavel(
                        resultSet.getInt("id_responsavel"),
                        resultSet.getString("nome"),
                        resultSet.getString("data_nascimento"),
                        resultSet.getString("rg"),
                        resultSet.getString("cpf")
                );
                responsavelList.add(responsavel);
            }


        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, resultSet);
        }

        return responsavelList;
    }

    //delete a responsavel from the system
    public void delete(Responsavel responsavel) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("DELETE FROM responsavel WHERE id_responsavel = ?");
            statement.setInt(1, responsavel.getId());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //select a responsavel by id
    public Responsavel selectById(int id) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        Responsavel responsavel = new Responsavel();

        try {

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
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return responsavel;
    }
}
