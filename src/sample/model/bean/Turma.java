package sample.model.bean;

public class Turma {

    private int id;
    private int idUsuario;
    private int idCurso;
    private String nome;
    private String dia;
    private String horario;
    private String dataInicio;

    public Turma() {
        this.id = 0;
        this.idUsuario = 0;
        this.idCurso = 0;
        this.nome = null;
        this.dia = null;
        this.horario = null;
        this.dataInicio = null;
    }

    public Turma(int id, int idUsuario, int idCurso,
                 String nome, String dia, String horario,
                 String dataInicio) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.idCurso = idCurso;
        this.nome = nome;
        this.dia = dia;
        this.horario = horario;
        this.dataInicio = dataInicio;
    }

    public Turma(int idUsuario, int idCurso, String nome,
                 String dia, String horario, String dataInicio) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.idCurso = idCurso;
        this.nome = nome;
        this.dia = dia;
        this.horario = horario;
        this.dataInicio = dataInicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
}
