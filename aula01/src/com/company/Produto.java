package com.company;

public class Produto extends Mercadoria implements Totalizavel {

    private double valorUnitario;
    private double valorDesconto;
    private boolean ativo;

    @Override
    public double obterTotal() {

        return this.valorUnitario - this.valorDesconto;
    }

    public double getValorUnitario() {

        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {

        if (valorUnitario >= 0)
            this.valorUnitario = valorUnitario;
    }

    public double getValorDesconto() {

        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        if (valorDesconto >= 0)
            this.valorDesconto = valorDesconto;
    }

    public boolean isAtivo() {

        return ativo;
    }

    public void setAtivo(boolean ativo) {

        this.ativo = ativo;
    }

}
