package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Frequencia;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrequenciaDAO {

    //Create a new frequencia on the system
    public void create(Frequencia frequencia) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement(
                    "INSERT INTO frequencia (" +
                            " alunos_turma_id_aluno_turma," +
                            " data) VALUES (?,?)"
            );

            statement.setInt(1, frequencia.getIdAlunoTurma());
            statement.setString(2, frequencia.getDate());

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

    //Delete a specific Frequencia
    public void delete(Frequencia frequencia) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("DELETE FROM frequencia WHERE id_frequencia = ?");
            statement.setInt(1, frequencia.getId());


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

    //Select a frequencia by id
    public Frequencia selectById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Frequencia frequencia = new Frequencia();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM frequencia WHERE id_frequencia = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                frequencia.setId(result.getInt("id_frequencia"));
                frequencia.setIdAlunoTurma(result.getInt("alunos_turma_id_aluno_turma"));
                frequencia.setDate(result.getString("data"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return frequencia;
    }
}
