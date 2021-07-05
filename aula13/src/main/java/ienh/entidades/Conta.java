package ienh.entidades;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Conta {

    public Conta(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private double saldo;

    private double limite;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinColumn(name = "idpessoafisica")
    private Pessoafisica pessoafisica;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinColumn(name = "idagencia")
    private Agencia agencia;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinColumn(name = "idgerente")
    private Gerente gerente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Pessoafisica getPessoafisica() {
        return pessoafisica;
    }

    public void setPessoafisica(Pessoafisica pessoafisica) {
        this.pessoafisica = pessoafisica;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
