package sample.model.bean;

public class Cancelamento {

    private int idFinanceiro;
    private String data;
    private double valor;

    public Cancelamento() {
        this.idFinanceiro = 0;
        this.data = null;
        this.valor = 0;
    }

    public Cancelamento(int id_financeiro, String data, double valor) {
        this.idFinanceiro = id_financeiro;
        this.data = data;
        this.valor = valor;
    }

    public int getIdFinanceiro() {
        return idFinanceiro;
    }

    public void setIdFinanceiro(int id_financeiro) {
        this.idFinanceiro = id_financeiro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
