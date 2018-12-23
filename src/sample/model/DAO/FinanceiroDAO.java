package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Financeiro;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinanceiroDAO {

    public void create(Financeiro financeiro) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement(
                    "INSERT INTO financeiro (" +
                            " alunos_id_aluno," +
                            " data_inicio," +
                            " vencimento," +
                            " num_parcelas," +
                            " valor," +
                            " taxa_juros," +
                            " multa," +
                            " matricula) VALUES (?,?,?,?,?,?,?,?)"
            );
            statement.setInt(1, financeiro.getIdAluno());
            statement.setString(2, financeiro.getDataInicio());
            statement.setString(3, financeiro.getVencimento());
            statement.setInt(4, financeiro.getNumParcelas());
            statement.setDouble(5, financeiro.getValor());
            statement.setDouble(6, financeiro.getTaxaJuros());
            statement.setDouble(7, financeiro.getMulta());
            statement.setDouble(8, financeiro.getMatricula());

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

    //Delete a specific financeiro
    public void delete(Financeiro financeiro) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("DELETE FROM financeiro WHERE id_financeiro = ?");
            statement.setInt(1, financeiro.getId());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }//Select a financeiro by id
    public Financeiro selectById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Financeiro financeiro = new Financeiro();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM financeiro WHERE id_financeiro = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                financeiro.setId(result.getInt("id_financeiro"));
                financeiro.setIdAluno(result.getInt("alunos_id_aluno"));
                financeiro.setDataInicio(result.getString("data_inicio"));
                financeiro.setVencimento(result.getString("vencimento"));
                financeiro.setNumParcelas(result.getInt("nu_parcelas"));
                financeiro.setValor(result.getDouble("valor"));
                financeiro.setTaxaJuros(result.getDouble("taxa_juros"));
                financeiro.setMulta(result.getDouble("multa"));
                financeiro.setMatricula(result.getDouble("matricula"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return financeiro;
    }

}
