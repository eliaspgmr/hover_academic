package sample.model.bean;

public class Boletim {

    private int id;
    private int idAlunoTurma;
    private double av1;
    private double av2;
    private double av3;
    private double av4;

    public Boletim() {
        this.id = 0;
        this.idAlunoTurma = 0;
        this.av1 = 0;
        this.av2 = 0;
        this.av3 = 0;
        this.av4 = 0;
    }

    public Boletim(int id, int idAlunoTurma, double av1, double av2, double av3, double av4) {

        this.id = id;
        this.idAlunoTurma = idAlunoTurma;
        this.av1 = av1;
        this.av2 = av2;
        this.av3 = av3;
        this.av4 = av4;
    }

    public Boletim(int idAlunoTurma, double av1, double av2, double av3, double av4) {

        this.id = id;
        this.idAlunoTurma = idAlunoTurma;
        this.av1 = av1;
        this.av2 = av2;
        this.av3 = av3;
        this.av4 = av4;
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

    public double getAv1() {
        return av1;
    }

    public void setAv1(double av1) {
        this.av1 = av1;
    }

    public double getAv2() {
        return av2;
    }

    public void setAv2(double av2) {
        this.av2 = av2;
    }

    public double getAv3() {
        return av3;
    }

    public void setAv3(double av3) {
        this.av3 = av3;
    }

    public double getAv4() {
        return av4;
    }

    public void setAv4(double av4) {
        this.av4 = av4;
    }
}
