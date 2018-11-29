package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Aluno;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO {

    //create a new aluno
    public void create(Aluno aluno) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(
                    "INSERT INTO alunos (" +
                            "usuarios_id_usuario," +
                            " responsavel_id_responsavel," +
                            " nome," +
                            " data_nascimento," +
                            " rg," +
                            " cpf," +
                            " sexo," +
                            " obs," +
                            " status" +
                            ")VALUES (?,?,?,?,?,?,?,?,?)"
            );
            statement.setInt(1, aluno.getIdUsuario());
            statement.setInt(2, aluno.getIdResponsavel());
            statement.setString(3, aluno.getNome());
            statement.setString(4, aluno.getDataNascimento());
            statement.setString(5, aluno.getRg());
            statement.setString(6, aluno.getCpf());
            statement.setString(7, aluno.getSexo());
            statement.setString(8, aluno.getObs());
            statement.setBoolean(9, aluno.getStatus());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //List all the alunos of the system
    public List<Aluno> listAlunos() {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Aluno> alunos = new ArrayList<>();

        try {

            statement = connection.prepareStatement("SELECT * FROM alunos");
            result = statement.executeQuery();

            while(result.next()) {

                Aluno aluno = new Aluno(
                        result.getInt("id_aluno"),
                        result.getInt("usuarios_id_usuario"),
                        result.getInt("responsavel_id_responsavel"),
                        result.getString("nome"),
                        result.getString("data_nascimento"),
                        result.getString("rg"),
                        result.getString("cpf"),
                        result.getString("sexo"),
                        result.getString("obs"),
                        result.getBoolean("status")
                );
                alunos.add(aluno);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return alunos;
    }

    //Select aluno by id
    public Aluno selectById(int id) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        Aluno aluno = new Aluno();

        try {

            statement = connection.prepareStatement("SELECT * FROM alunos WHERE id_aluno = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                aluno.setId(result.getInt("id_aluno"));
                aluno.setIdUsuario(result.getInt("usuarios_id_usuario"));
                aluno.setIdResponsavel(result.getInt("responsavel_id_responsavel"));
                aluno.setNome(result.getString("nome"));
                aluno.setDataNascimento(result.getString("data_nascimento"));
                aluno.setRg(result.getString("rg"));
                aluno.setCpf(result.getString("cpf"));
                aluno.setSexo(result.getString("sexo"));
                aluno.setObs(result.getString("obs"));
                aluno.setStatus(result.getBoolean("status"));

            }else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return aluno;
    }

    //Delete a specific aluno
    public void delete(Aluno aluno) {

        Connection connection = ConnectionHover.getConnection();
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("DELETE FROM alunos WHERE id_aluno = ?");
            statement.setInt(1, aluno.getId());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }
}
