package com.company;


public class Programa {

    public static void main(String[] args) {

        Produto produto1 = new Produto();

        produto1.setId(1);
        produto1.setValorUnitario(110);
        produto1.setValorDesconto(10);
        produto1.setAtivo(true);

        Produto produto2 = new Produto();

        produto2.setId(2);
        produto2.setValorUnitario(110);
        produto2.setValorDesconto(10);
        produto2.setAtivo(true);

        Produto produto3 = new Produto();

        produto3.setId(3);
        produto3.setValorUnitario(110);
        produto3.setValorDesconto(10);
        produto3.setAtivo(true);

        Aluno aluno1 = new Aluno();

        aluno1.setId(1);
        aluno1.setNomeCompleto("Aluno 1");

        Aluno aluno2 = new Aluno();

        aluno2.setId(2);
        aluno2.setNomeCompleto("Aluno 1");

        Aluno aluno3 = new Aluno();

        aluno3.setId(3);
        aluno3.setNomeCompleto("Aluno 1");

        Aluno aluno4 = new Aluno();

        aluno4.setId(4);
        aluno4.setNomeCompleto("Aluno 1");

        Mensalidade mensalidade1 = new Mensalidade();

        mensalidade1.setId(1);
        mensalidade1.setAluno(aluno1);
        mensalidade1.setValor(100);

        Mensalidade mensalidade2 = new Mensalidade();

        mensalidade2.setId(2);
        mensalidade2.setAluno(aluno2);
        mensalidade2.setValor(100);

        Mensalidade mensalidade3 = new Mensalidade();

        mensalidade3.setId(3);
        mensalidade3.setAluno(aluno3);
        mensalidade3.setValor(100);

        Mensalidade mensalidade4 = new Mensalidade();

        mensalidade4.setId(4);
        mensalidade4.setAluno(aluno4);
        mensalidade4.setValor(100);

        Operacoes operacoes = new Operacoes();

        operacoes.adicionarObejtos(produto1);
        operacoes.adicionarObejtos(produto2);
        operacoes.adicionarObejtos(produto3);

        operacoes.adicionarObejtos(mensalidade1);
        operacoes.adicionarObejtos(mensalidade2);
        operacoes.adicionarObejtos(mensalidade3);
        operacoes.adicionarObejtos(mensalidade4);

        System.out.println(" ");
        System.out.println("A soma de todas as mensalidades e todos os produtos foi de R$" + operacoes.somar());
        System.out.println(" ");
    }

}
