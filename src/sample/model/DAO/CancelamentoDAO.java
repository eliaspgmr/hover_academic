package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Cancelamento;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CancelamentoDAO {

    //Create a new cancelamento on the system
    public void create(Cancelamento cancelamento) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(
                    "INSERT INTO cancelamento (" +
                            " financeiro_id_financeiro," +
                            " data," +
                            " valor) VALUES (?,?,?)"
            );
            statement.setInt(1, cancelamento.getIdFinanceiro());
            statement.setString(2, cancelamento.getData());
            statement.setDouble(3, cancelamento.getValor());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Delete a specific cancelamento
    public void delete(Cancelamento cancelamento) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("DELETE FROM cancelamento WHERE financeiro_id_financeiro = ?");
            statement.setInt(1, cancelamento.getIdFinanceiro());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Select a endereco by id
    public Cancelamento electById(int id) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        Cancelamento cancelamento = new Cancelamento();

        try {

            statement = connection.prepareStatement("SELECT * FROM cancelamento WHERE financeiro_id_financeiro = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                cancelamento.setIdFinanceiro(result.getInt("financeiro_id_financeiro"));
                cancelamento.setData(result.getString("data"));
                cancelamento.setValor(result.getDouble("valor"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return cancelamento;
    }
}
