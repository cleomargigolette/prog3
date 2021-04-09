package com.company;

import java.util.ArrayList;

public class Operacoes {

    private ArrayList<Totalizavel> objetos;

    public Operacoes() {

        this.objetos = new ArrayList<>();
    }

    public void adicionarObejtos(Totalizavel objeto) {

        this.objetos.add(objeto);
    }

    public double somar() {

        return objetos.stream().mapToDouble(Totalizavel::obterTotal).sum();
    }

    public ArrayList<Totalizavel> getObjetos() {

        return objetos;
    }

}
