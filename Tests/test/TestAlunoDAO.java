package test;

import sample.model.DAO.AlunoDAO;
import sample.model.bean.Aluno;
import sample.model.bean.ServerSession;

public class TestAlunoDAO {

    public static void main(String args[]) {
        ServerSession.update();

        AlunoDAO dao = new AlunoDAO();

        Aluno aluno = new Aluno(
                1,
                2,
                "elias",
                "1991/04/04",
                "20072149501",
                "05116544303",
                "m",
                "asdf",
                true
        );

        dao.create(aluno);

    }
}
