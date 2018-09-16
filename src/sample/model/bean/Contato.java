package sample.model.bean;

public class Contato {
    private int id;
    private int id_aluno;
    private int telefone;
    private int celular;
    private String email;

    public Contato() {
        this.id = 0;
        this.id_aluno = 0;
        this.telefone = 0;
        this.celular = 0;
        this.email = null;
    }

    public Contato(int id_aluno, int telefone, int celular, String email) {
        this.id_aluno = id_aluno;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public Contato(int id, int id_aluno, int telefone, int celular, String email) {
        this.id = id;
        this.id_aluno = id_aluno;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
