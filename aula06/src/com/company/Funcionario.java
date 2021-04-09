package com.company;

import java.time.LocalDate;

public class Funcionario {

    public Funcionario(String nomeCompleto, String cpf, String enderecoResidencial, LocalDate aniversario) {

        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.enderecoResidencial = enderecoResidencial;
        this.aniversario = aniversario;
    }

    public Funcionario() {

    }

    private String nomeCompleto;
    private String cpf;
    private String enderecoResidencial;
    private LocalDate aniversario;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(String enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }
}
