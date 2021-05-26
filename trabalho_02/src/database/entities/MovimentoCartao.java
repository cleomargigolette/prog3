package database.entities;

import java.time.LocalDateTime;

public class MovimentoCartao {

    private long id;
    private LocalDateTime data;
    private double valor;
    private long idfatura;
    private long idcartao;
    private long idestabelecimento;

    public MovimentoCartao() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(long idfatura) {
        this.idfatura = idfatura;
    }

    public long getIdcartao() {
        return idcartao;
    }

    public void setIdcartao(long idcartao) {
        this.idcartao = idcartao;
    }

    public long getIdestabelecimento() {
        return idestabelecimento;
    }

    public void setIdestabelecimento(long idestabelecimento) {
        this.idestabelecimento = idestabelecimento;
    }
}
