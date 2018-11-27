package sample.model.bean;

public class Parcela {

    private int idFinanceiro;
    private int numero;
    private double valor;
    private double juros;
    private double multa;
    private String dataPagamento;

    public Parcela() {

        this.idFinanceiro =0;
        this.numero = 0;
        this.valor =0;
        this.juros =0;
        this.multa =0;
        this.dataPagamento = null;
    }

    public Parcela(int idFinanceiro, int numero, double valor,
                   double juros, double multa, String dataPagamento) {

        this.idFinanceiro = idFinanceiro;
        this.numero = numero;
        this.valor =valor;
        this.juros =juros;
        this.multa =multa;
        this.dataPagamento = dataPagamento;
    }


    public int getIdFinanceiro() {
        return idFinanceiro;
    }

    public void setIdFinanceiro(int idFinanceiro) {
        this.idFinanceiro = idFinanceiro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
