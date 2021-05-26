package database.entities;

public class Cartao {

    private long id;
    private String numero;
    private double limite;
    private int diaVencimento;
    private long idconta;
    private long idbandeira;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public long getIdconta() {
        return idconta;
    }

    public void setIdconta(long idconta) {
        this.idconta = idconta;
    }

    public long getIdbandeira() {
        return idbandeira;
    }

    public void setIdbandeira(long idbandeira) {
        this.idbandeira = idbandeira;
    }
}
