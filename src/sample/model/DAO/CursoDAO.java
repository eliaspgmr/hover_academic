package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Curso;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursoDAO {

    //Create a new curso on the system
    public void create(Curso curso) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement(
                    "INSERT INTO cursos (" +
                            " nome," +
                            " nivel," +
                            " duracao," +
                            " valor) VALUES (?,?,?,?)"
            );

            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getNivel());
            statement.setInt(3, curso.getDuracao());
            statement.setDouble(4, curso.getValor());

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

    //Delete a specific curso
    public void delete(Curso curso) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("DELETE FROM cursos WHERE id_curso = ?");
            statement.setInt(1, curso.getId());


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

    //Select a curso by id
    public Curso selectById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Curso curso = new Curso();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM cursos WHERE id_curso = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                curso.setId(result.getInt("id_curso"));
                curso.setNome(result.getString("nome"));
                curso.setNivel(result.getString("nivel"));
                curso.setDuracao(result.getInt("duracao"));
                curso.setValor(result.getDouble("valor"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return curso;
    }
}
