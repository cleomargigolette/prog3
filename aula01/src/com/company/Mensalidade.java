package com.company;

public class Mensalidade implements Totalizavel {

    private int id;
    private Aluno aluno;
    private double valor;

    @Override
    public double obterTotal() {

        return this.valor;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        if (id >= 0)
            this.id = id;
    }

    public Aluno getAluno() {

        return aluno;
    }

    public void setAluno(Aluno aluno) {

        this.aluno = aluno;
    }

    public double getValor() {

        return this.valor;
    }

    public void setValor(double valor) {

        if (valor >= 0)
            this.valor = valor;
    }

}
