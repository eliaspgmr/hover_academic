package sample.model.bean;
/**
 * hover-academic
 * Class Responsavel
 * @author hover
 */
public class Responsavel {

    private int id;
    private String nome;
    private String dataNascimento;
    private String rg;
    private String cpf;

    public Responsavel() {
        this.id = 0;
        this.nome = null;
        this.dataNascimento = null;
        this.rg = null;
        this.cpf = null;
    }

    public Responsavel(String nome, String dataNascimento, String rg, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
    }

    public Responsavel(int id, String nome, String dataNascimento, String rg, String cpf) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String  getRg() {
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
}
