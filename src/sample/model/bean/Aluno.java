package sample.model.bean;

public class Aluno {

    private int id;
    private Usuario usuario;
    private Responsavel responsavel;
    private String nome;
    private String dataNascimento;
    private String rg;
    private String cpf;
    private String sexo;
    private String obs;
    private boolean status;

    public Aluno() {
        this.id =0;
        this.usuario = new Usuario();
        this.responsavel = new Responsavel();
        this.nome = null;
        this.dataNascimento = null;
        this.rg = null;
        this.cpf = null;
        this.sexo = null;
        this.obs = null;
        this.status = false;
    }

    public Aluno(int id, String nome, String dataNascimento,
                 String rg, String cpf, String sexo,
                 String obs, boolean status) {

        this.id = id;
        this.usuario = new Usuario();
        this.responsavel = new Responsavel();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
        this.obs = obs;
        this.status = status;

    }

    public Aluno(String nome, String dataNascimento,
                 String rg, String cpf, String sexo,
                 String obs, boolean status) {

        this.id = 0;
        this.usuario = new Usuario();
        this.responsavel = new Responsavel();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
        this.obs = obs;
        this.status = status;

    }

    public Aluno(Usuario usuario, Responsavel responsavel, String nome,
                 String dataNascimento, String rg, String cpf,
                 String sexo, String obs, boolean status) {

        this.id =0;
        this.usuario = usuario;
        this.responsavel = responsavel;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
        this.obs = obs;
        this.status = status;

    }

    public Aluno(int id, Usuario usuario, Responsavel responsavel, String nome,
                 String dataNascimento, String rg, String cpf,
                 String sexo, String obs, boolean status) {

        this.id = id;
        this.usuario = usuario;
        this.responsavel = responsavel;
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

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setIdUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Responsavel getResponsavel() {
        return this.responsavel;
    }

    public void setIdResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
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
