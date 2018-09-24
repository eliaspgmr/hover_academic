package sample.model.bean;

public class Contato {
    private int id;
    private int idAluno;
    private int telefone;
    private int celular;
    private String email;

    public Contato() {
        this.id = 0;
        this.idAluno = 0;
        this.telefone = 0;
        this.celular = 0;
        this.email = null;
    }

    public Contato(int idAluno, int telefone, int celular, String email) {
        this.idAluno = idAluno;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public Contato(int id, int idAluno, int telefone, int celular, String email) {
        this.id = id;
        this.idAluno = idAluno;
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

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
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
