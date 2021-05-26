package database.entities;

import java.time.LocalDateTime;

public class Fatura {

    private long id;
    private LocalDateTime vencimento;
    private double valor;
    private double valorminimo;
    private LocalDateTime datapagamento;
    private double valorpago;
    private long idcartao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorminimo() {
        return valorminimo;
    }

    public void setValorminimo(double valorminimo) {
        this.valorminimo = valorminimo;
    }

    public LocalDateTime getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(LocalDateTime datapagamento) {
        this.datapagamento = datapagamento;
    }

    public double getValorpago() {
        return valorpago;
    }

    public void setValorpago(double valorpago) {
        this.valorpago = valorpago;
    }

    public long getIdcartao() {
        return idcartao;
    }

    public void setIdcartao(long idcartao) {
        this.idcartao = idcartao;
    }
}
