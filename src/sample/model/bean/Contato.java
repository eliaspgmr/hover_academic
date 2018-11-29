package sample.model.bean;

public class Contato {
    private int id;
    private int idAluno;
    private String telefone;
    private String celular;
    private String email;

    public Contato() {
        this.id = 0;
        this.idAluno = 0;
        this.telefone = null;
        this.celular = null;
        this.email = null;
    }

    public Contato(int idAluno, String telefone, String celular, String email) {
        this.idAluno = idAluno;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public Contato(int id, int idAluno, String telefone, String celular, String email) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
