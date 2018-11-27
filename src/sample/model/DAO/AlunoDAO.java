package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Aluno;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
