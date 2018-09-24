package sample.model.bean;

public class Frequencia {
    private int id;
    private int idAlunoTurma;
    private String date;

    public Frequencia() {

        this.id = 0;
        this.idAlunoTurma =0;
        this.date = null;
    }

    public Frequencia(int id, int idAlunoTurma, String date) {

        this.id = id;
        this.idAlunoTurma = idAlunoTurma;
        this.date = date;
    }

    public Frequencia(int idAlunoTurma, String date) {

        this.idAlunoTurma = idAlunoTurma;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlunoTurma() {
        return idAlunoTurma;
    }

    public void setIdAlunoTurma(int idAlunoTurma) {
        this.idAlunoTurma = idAlunoTurma;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
