package sample.model.bean;

public class Endereco {
    private int id;
    private int id_aluno;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;

    public Endereco() {
        this.id = 0;
        this.id_aluno = 0;
        this.rua = null;
        this.numero = 0;
        this.bairro = null;
        this.cidade = null;
        this.estado = null;
        this.cep = 0;
    }
    public Endereco(int id_aluno, String rua, int numero, String bairro, String cidade, String estado, int cep) {
        this.id_aluno = id_aluno;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade =cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Endereco(int id, int id_aluno, String rua, int numero, String bairro, String cidade, String estado, int cep) {
        this.id = id;
        this.id_aluno = id_aluno;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade =cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
}
