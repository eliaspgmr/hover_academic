package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Endereco;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDAO {

    //Create a new endereco on the system
    public void create(Endereco endereco) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(
                    "INSERT INTO endereco (" +
                            "alunos_id_aluno," +
                            " rua," +
                            " numero," +
                            " bairro," +
                            " cidade," +
                            " estado," +
                            " cep) VALUES (?,?,?,?,?,?,?)"
            );
            statement.setInt(1, endereco.getIdAluno());
            statement.setString(2, endereco.getRua());
            statement.setInt(3, endereco.getNumero());
            statement.setString(4, endereco.getBairro());
            statement.setString(5, endereco.getCidade());
            statement.setString(6, endereco.getEstado());
            statement.setString(7, endereco.getCep());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Delete a specific endereco
    public void delete(Endereco endereco) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("DELETE FROM endereco WHERE id_endereco = ?");
            statement.setInt(1, endereco.getId());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Select a endereco by id
    public Endereco selectById(int id) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        Endereco endereco = new Endereco();

        try {

            statement = connection.prepareStatement("SELECT * FROM endereco WHERE id_endereco = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                endereco.setId(result.getInt("id_endereco"));
                endereco.setIdAluno(result.getInt("alunos_id_aluno"));
                endereco.setRua(result.getString("rua"));
                endereco.setNumero(result.getInt("numero"));
                endereco.setBairro(result.getString("bairro"));
                endereco.setCidade(result.getString("cidade"));
                endereco.setEstado(result.getString("estado"));
                endereco.setCep(result.getString("cep"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return endereco;
    }
}
