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
    private int rg;
    private int cpf;

    public Responsavel() {
        this.id = 0;
        this.nome = null;
        this.dataNascimento = null;
        this.rg = 0;
        this.cpf = 0;
    }

    public Responsavel(String nome, String dataNascimento, int rg, int cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
    }

    public Responsavel(int id, String nome, String dataNascimento, int rg, int cpf) {
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
}
