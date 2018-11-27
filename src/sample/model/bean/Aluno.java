package sample.model.bean;

public class Aluno {

    private int id;
    private int idUsuario;
    private int idResponsavel;
    private String nome;
    private String dataNascimento;
    private String rg;
    private String cpf;
    private String sexo;
    private String obs;
    private boolean status;

    public Aluno() {
        this.id =0;
        this.idUsuario = 0;
        this.idResponsavel = 0;
        this.nome = null;
        this.dataNascimento = null;
        this.rg = null;
        this.cpf = null;
        this.sexo = null;
        this.obs = null;
        this.status = false;
    }

    public Aluno(int idUsuario, int idResponsavel, String nome,
                 String dataNascimento, String rg, String cpf,
                 String sexo, String obs, boolean status) {

        this.idUsuario = idUsuario;
        this.idResponsavel = idResponsavel;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
        this.obs = obs;
        this.status = status;
    }

    public Aluno(int id, int idUsuario, int idResponsavel, String nome,
                 String dataNascimento, String rg, String cpf,
                 String sexo, String obs, boolean status) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.idResponsavel = idResponsavel;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
        this.obs = obs;
        this.status = status;
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

    public void setIdUsuario(int id_usuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String data_nascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
