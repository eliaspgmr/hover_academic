package sample.model.bean;

public class Curso {
    private int id;
    private String nome;
    private String nivel;
    private int duracao;
    private double valor;

    public Curso() {
        this.id = 0;
        this.nome = null;
        this.nivel = null;
        this.duracao = 0;
        this.valor = 0;
    }

    public Curso(int id, String nome, String nivel, int duracao, double valor) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.duracao =duracao;
        this.valor = valor;
    }

    public Curso(String nome, String nivel, int duracao, double valor) {
        this.nome = nome;
        this.nivel = nivel;
        this.duracao =duracao;
        this.valor = valor;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
