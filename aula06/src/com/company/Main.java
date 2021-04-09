package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setAniversario(LocalDate.of(1991,02,06));
        funcionario1.setCpf("02611458785");
        funcionario1.setEnderecoResidencial("Rua Pedro Alvares, N°123, Roselândia, Novo Hamburgo, RS");
        funcionario1.setNomeCompleto("Cleomar Gigolette da Silva");

        Contrato contratoFuncionario1 = new Contrato();
        contratoFuncionario1.setFuncionario(funcionario1);
        contratoFuncionario1.setValorHora(31.9);
        contratoFuncionario1.setDataFim(LocalDate.of(2020,01,01));
        contratoFuncionario1.setDataInicio(LocalDate.of(2009,01,01));
        contratoFuncionario1.setQuantidadeHorasSemanais(30);

        System.out.println("Bonicação do funcionário 1: R$"+Calculador.calcularBonificacao(contratoFuncionario1));

    }
}
