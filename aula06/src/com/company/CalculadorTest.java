package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class CalculadorTest extends Calculador {

    private Contrato contratoFuncionario1 = new Contrato();

    @Before
    public void setUp() throws Exception {

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setAniversario(LocalDate.of(1991,02,06));
        funcionario1.setCpf("02611458785");
        funcionario1.setEnderecoResidencial("Rua Pedro Alvares, N°123, Roselândia, Novo Hamburgo, RS");
        funcionario1.setNomeCompleto("Cleomar Gigolette da Silva");

        contratoFuncionario1.setFuncionario(funcionario1);
    }

    @Test
    public void testCalcularBonificacao4Anos() {

        double expected = 78.474;

        contratoFuncionario1.setValorHora(31.9);
        contratoFuncionario1.setQuantidadeHorasSemanais(30);
        contratoFuncionario1.setDataInicio(LocalDate.of(2016,01,01));
        contratoFuncionario1.setDataFim(LocalDate.of(2020,01,01));

        double actual = Calculador.calcularBonificacao(contratoFuncionario1);

        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCalcularBonificacao5anos() {

        double expected = 161.4459;

        contratoFuncionario1.setValorHora(31.9);
        contratoFuncionario1.setQuantidadeHorasSemanais(30);
        contratoFuncionario1.setDataInicio(LocalDate.of(2015,01,01));
        contratoFuncionario1.setDataFim(LocalDate.of(2020,01,01));

        double actual = Calculador.calcularBonificacao(contratoFuncionario1);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcularBonificacao7anos() {

        double expected = 161.4459;

        contratoFuncionario1.setValorHora(31.9);
        contratoFuncionario1.setQuantidadeHorasSemanais(30);
        contratoFuncionario1.setDataInicio(LocalDate.of(2013,01,01));
        contratoFuncionario1.setDataFim(LocalDate.of(2020,01,01));

        double actual = Calculador.calcularBonificacao(contratoFuncionario1);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcularBonificacao11anos() {

        double expected = 212.5497;

        contratoFuncionario1.setValorHora(31.9);
        contratoFuncionario1.setQuantidadeHorasSemanais(30);
        contratoFuncionario1.setDataInicio(LocalDate.of(2009,01,01));
        contratoFuncionario1.setDataFim(LocalDate.of(2020,01,01));

        double actual = Calculador.calcularBonificacao(contratoFuncionario1);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcularBonificacao12anos() {

        double expected = 429.292648;

        contratoFuncionario1.setValorHora(26.12);
        contratoFuncionario1.setQuantidadeHorasSemanais(74);
        contratoFuncionario1.setDataInicio(LocalDate.of(2008,01,01));
        contratoFuncionario1.setDataFim(LocalDate.of(2020,01,01));

        double actual = Calculador.calcularBonificacao(contratoFuncionario1);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcularBonificacao8anos74horas() {

        double expected = 327.070556;

        contratoFuncionario1.setValorHora(26.2);
        contratoFuncionario1.setQuantidadeHorasSemanais(74);
        contratoFuncionario1.setDataInicio(LocalDate.of(2012,01,01));
        contratoFuncionario1.setDataFim(LocalDate.of(2020,01,01));

        double actual = Calculador.calcularBonificacao(contratoFuncionario1);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcularBonificacao8anos80horas() {

        double expected = 280.86400000000003;

        contratoFuncionario1.setValorHora(26.2);
        contratoFuncionario1.setQuantidadeHorasSemanais(80);
        contratoFuncionario1.setDataInicio(LocalDate.of(2012,01,01));
        contratoFuncionario1.setDataFim(LocalDate.of(2020,01,01));

        double actual = Calculador.calcularBonificacao(contratoFuncionario1);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcularBonificacao8anos120horas() {

        double expected = 421.29600000000005;

        contratoFuncionario1.setValorHora(26.2);
        contratoFuncionario1.setQuantidadeHorasSemanais(120);
        contratoFuncionario1.setDataInicio(LocalDate.of(2012,01,01));
        contratoFuncionario1.setDataFim(LocalDate.of(2020,01,01));

        double actual = Calculador.calcularBonificacao(contratoFuncionario1);

        Assert.assertEquals(expected, actual, 0.1);
    }
}