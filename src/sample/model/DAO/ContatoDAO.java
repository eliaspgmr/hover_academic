package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Contato;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatoDAO {

    //Create a new contato on the system
    public void create(Contato contato) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(
                    "INSERT INTO contatos (" +
                            "alunos_id_aluno," +
                            " telefone," +
                            " celular," +
                            " email) VALUES (?,?,?,?)"
            );
            statement.setInt(1, contato.getIdAluno());
            statement.setString(2, contato.getTelefone());
            statement.setString(3, contato.getCelular());
            statement.setString(4, contato.getEmail());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Delete a specific contato
    public void delete(Contato contato) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("DELETE FROM contatos WHERE id_contato = ?");
            statement.setInt(1, contato.getId());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Select a contato by id
    public Contato selectById(int id) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        Contato contato = new Contato();

        try {

            statement = connection.prepareStatement("SELECT * FROM contatos WHERE id_contato = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                contato.setId(result.getInt("id_contato"));
                contato.setIdAluno(result.getInt("alunos_id_aluno"));
                contato.setTelefone(result.getString("telefone"));
                contato.setCelular(result.getString("celular"));
                contato.setEmail(result.getString("email"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return contato;
    }
}
