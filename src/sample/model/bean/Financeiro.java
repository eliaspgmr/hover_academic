package sample.model.bean;

public class Financeiro {

    private int id;
    private int idAluno;
    private String dataInicio;
    private String vencimento;
    private int numParcelas;
    private double valor;
    private double taxaJuros;
    private double multa;
    private double matricula;

    public Financeiro() {

        this.id = 0;
        this.idAluno =0;
        this.dataInicio = null;
        this.vencimento = null;
        this.numParcelas = 0;
        this.valor = 0;
        this.taxaJuros = 0;
        this.multa = 0;
        this.matricula = 0;

    }

    public Financeiro(int id, int idAluno, String dataInicio,
                      String vencimento, int numParcelas, double valor,
                      double taxaJuros, double multa, double matricula) {

        this.id = id;
        this.idAluno = idAluno;
        this.dataInicio = dataInicio;
        this.vencimento = vencimento;
        this.numParcelas = numParcelas;
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.multa = multa;
        this.matricula = matricula;

    }

    public Financeiro(int idAluno, String dataInicio, String vencimento,
                      int numParcelas, double valor, double taxaJuros,
                      double multa, double matricula) {

        this.idAluno = idAluno;
        this.dataInicio = dataInicio;
        this.vencimento = vencimento;
        this.numParcelas = numParcelas;
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.multa = multa;
        this.matricula = matricula;

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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }
}
