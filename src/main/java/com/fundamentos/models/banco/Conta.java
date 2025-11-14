package com.fundamentos.models.banco;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Conta {

    private Long id;
    private String agencia;
    private String numero;
    private Double saldo;
    private boolean ativo;

    // * Contrutores
    public Conta() {}

    public Conta(Long id, String agencia, String numero) {
        this.id = id;
        this.agencia = agencia;
        this.numero = numero;
        this.ativo = true;
        this.saldo = 0.0;
    }

    // * Métodos privados

    // private void aumentarSaldo(Double valor) {

    // }

    // private void diminuirSalto(Double valor) {

    // }

    // * Métodos públicos

    public void depositar(Double valor) {
        if(!this.ativo) {
            throw new RuntimeException("Conta desativada não pode receber depositos.");
        } else if(valor < 0.0) {
            throw new RuntimeException("Depósito não pode ter valor negativo.");
        }
        this.saldo += valor;
    }
    
    public void sacar(Double valor) {
        if(!this.ativo) {
            throw new RuntimeException("Conta desativada não pode realizar Saque");
        } else if(valor < 0.0) {
            throw new RuntimeException("Saque não pode ter valor negativo.");
        }
        this.saldo -= valor;
    }

    public void tranferir(Conta conta, Double valor) {
        if(conta == null || valor == null) {
            throw new RuntimeException("Não autorizado, parâmetros nulos.");
        } else if(!this.ativo) {
            throw new RuntimeException("Não autorizado, conta origem está desativada.");
        } else if(!conta.ativo) {
            throw new RuntimeException("Não autorizado, conta destino está desativada.");
        } else if(valor < 0.0) {
            throw new RuntimeException("Transferência com valor negativo não autorizado.");
        }
        this.saldo -= valor;
        conta.saldo += valor;
    }

    public void ativarConta() {

    }

    public void desativarConta() {

    }

}
