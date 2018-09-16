package sample.model.bean;

public class Aluno {

    private int id;
    private int id_usuario;
    private int id_responsavel;
    private String nome;
    private String data_nascimento;
    private int rg;
    private int cpf;
    private char sexo;
    private String obs;
    private boolean status;

    public Aluno() {
        this.id =0;
        this.id_usuario = 0;
        this.id_responsavel = 0;
        this.nome = null;
        this.data_nascimento = null;
        this.rg = 0;
        this.cpf = 0;
        this.sexo = ' ';
        this.obs = null;
        this.status = false;
    }

    public Aluno(int id_usuario,
                 int id_responsavel,
                 String nome,
                 String data_nascimento,
                 int rg,
                 int cpf,
                 char sexo,
                 String obs,
                 boolean status) {

        this.id_usuario = id_usuario;
        this.id_responsavel = id_responsavel;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
        this.obs = obs;
        this.status = status;
    }

    public Aluno(int id,
                 int id_usuario,
                 int id_responsavel,
                 String nome,
                 String data_nascimento,
                 int rg,
                 int cpf,
                 char sexo,
                 String obs,
                 boolean status) {

        this.id = id;
        this.id_usuario = id_usuario;
        this.id_responsavel = id_responsavel;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_responsavel() {
        return id_responsavel;
    }

    public void setId_responsavel(int id_responsavel) {
        this.id_responsavel = id_responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
