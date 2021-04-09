package com.company;

public class Aluno {

    private int id;
    private String nomeCompleto;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        if (id >= 0)
            this.id = id;
    }

    public String getNomeCompleto() {

        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {

        if (nomeCompleto.isEmpty() == false)
            this.nomeCompleto = nomeCompleto;
    }

}
