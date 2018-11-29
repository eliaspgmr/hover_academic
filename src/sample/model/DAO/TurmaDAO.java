package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Turma;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurmaDAO {

    //Create a new turma on the system
    public void create(Turma turma) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(
                    "INSERT INTO turma (" +
                            " usuarios_id_usuario," +
                            " cursos_id_curso," +
                            " nome," +
                            " dia," +
                            " horario," +
                            " data_inicio) VALUES (?,?,?,?,?,?)"
            );

            statement.setInt(1, turma.getIdUsuario());
            statement.setInt(2, turma.getIdCurso());
            statement.setString(3, turma.getNome());
            statement.setString(4, turma.getDia());
            statement.setString(5, turma.getHorario());
            statement.setString(6, turma.getDataInicio());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Delete a specific turma
    public void delete(Turma turma) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("DELETE FROM turma WHERE id_turma = ?");
            statement.setInt(1, turma.getId());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Select a turma by id
    public Turma selectById(int id) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        Turma turma = new Turma();

        try {

            statement = connection.prepareStatement("SELECT * FROM turma WHERE id_turma = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                turma.setId(result.getInt("id_turma"));
                turma.setIdUsuario(result.getInt("usuarios_id_usuario"));
                turma.setIdCurso(result.getInt("cursos_id_curso"));
                turma.setNome(result.getString("nome"));
                turma.setDia(result.getString("dia"));
                turma.setHorario(result.getString("horario"));
                turma.setDataInicio(result.getString("data_inicio"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return turma;
    }
}
