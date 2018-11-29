package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Boletim;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoletimDAO {

    //Create a new boletim on the system
    public void create(Boletim boletim) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(
                    "INSERT INTO boletim (" +
                            " alunos_turma_id_aluno_turma," +
                            " av1," +
                            " av2," +
                            " av3," +
                            " av4) VALUES (?,?,?,?,?)"
            );

            statement.setInt(1, boletim.getIdAlunoTurma());
            statement.setDouble(2, boletim.getAv1());
            statement.setDouble(3, boletim.getAv2());
            statement.setDouble(4, boletim.getAv3());
            statement.setDouble(5, boletim.getAv4());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Delete a specific boletim
    public void delete(Boletim boletim) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("DELETE FROM boletim WHERE id_boletim = ?");
            statement.setInt(1, boletim.getId());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Select a boletim by id
    public Boletim selectById(int id) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        Boletim boletim = new Boletim();

        try {

            statement = connection.prepareStatement("SELECT * FROM boletim WHERE id_boletim = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                boletim.setId(result.getInt("id_boletim"));
                boletim.setIdAlunoTurma(result.getInt("alunos_turma_id_aluno_turma"));
                boletim.setAv1(result.getDouble("av1"));
                boletim.setAv2(result.getDouble("av2"));
                boletim.setAv3(result.getDouble("av3"));
                boletim.setAv4(result.getDouble("av4"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return boletim;
    }
}
