package sample.model.bean;

public class AlunoTurma {

    private int id;
    private int idTurma;
    private int idAluno;

    public AlunoTurma() {
        this.id = 0;
        this.idTurma = 0;
        this.idAluno = 0;
    }

    public AlunoTurma(int id, int id_turma, int id_aluno) {
        this.id = id;
        this.idTurma = id_turma;
        this.idAluno = id_aluno;
    }

    public AlunoTurma(int id_turma, int id_aluno) {

        this.idTurma = id_turma;
        this.idAluno = id_aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int id_turma) {
        this.idTurma = id_turma;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int id_aluno) {
        this.idAluno = id_aluno;
    }
}
