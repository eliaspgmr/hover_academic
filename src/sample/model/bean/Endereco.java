package sample.model.bean;

public class Endereco {
    private int id;
    private int idAluno;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco() {
        this.id = 0;
        this.idAluno = 0;
        this.rua = null;
        this.numero = 0;
        this.bairro = null;
        this.cidade = null;
        this.estado = null;
        this.cep = null;
    }
    public Endereco(int idAluno, String rua, int numero, String bairro,
                    String cidade, String estado, String cep) {
        this.idAluno = idAluno;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade =cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Endereco(int id, int idAluno, String rua, int numero,
                    String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.idAluno = idAluno;
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

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int id_aluno) {
        this.idAluno = id_aluno;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
