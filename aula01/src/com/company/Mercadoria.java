package com.company;

public class Mercadoria {

    private int id;
    private String nome;
    private String descricao;

    public int getId() {

        return this.id;
    }

    public void setId(int id) {

        if(id >= 0)
            this.id = id;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

}
