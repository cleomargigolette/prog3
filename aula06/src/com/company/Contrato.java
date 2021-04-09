package com.company;

import java.time.LocalDate;

public class Contrato {

    public Contrato(LocalDate dataInicio, LocalDate dataFim, Funcionario funcionario, int quantidadeHorasSemanais, double valorHora) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.funcionario = funcionario;
        this.quantidadeHorasSemanais = quantidadeHorasSemanais;
        this.valorHora = valorHora;
    }

    public Contrato() {

    }

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Funcionario funcionario;
    private int quantidadeHorasSemanais;
    private double valorHora;

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getQuantidadeHorasSemanais() {
        return quantidadeHorasSemanais;
    }

    public void setQuantidadeHorasSemanais(int quantidadeHorasSemanais) {
        this.quantidadeHorasSemanais = quantidadeHorasSemanais;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
