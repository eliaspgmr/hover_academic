package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.AlunoTurma;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoTurmaDAO {

    //Create a new alunoTurma on the system
    public void create(AlunoTurma alunoTurma) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement(
                    "INSERT INTO alunos_turma (" +
                            " turma_id_turma," +
                            " alunos_id_aluno) VALUES (?,?)"
            );

            statement.setInt(1, alunoTurma.getIdTurma());
            statement.setInt(2, alunoTurma.getIdAluno());

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

    //Delete a specific alunoTurma
    public void delete(AlunoTurma alunoTurma) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("DELETE FROM alunos_turma WHERE id_aluno_turma = ?");
            statement.setInt(1, alunoTurma.getId());


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

    //Select a alunoTurma by id
    public AlunoTurma selectById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        AlunoTurma alunoTurma = new AlunoTurma();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM alunos_turma WHERE id_aluno_turma = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {

                alunoTurma.setId(result.getInt("id_aluno_turma"));
                alunoTurma.setIdTurma(result.getInt("turma_id_turma"));
                alunoTurma.setIdAluno(result.getInt("alunos_id_aluno"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return alunoTurma;
    }
}
