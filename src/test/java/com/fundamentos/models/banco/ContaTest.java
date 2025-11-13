package com.fundamentos.models.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ContaTest {

    // * Instancia de Conta

    Conta contaNova01 = new Conta(1L, "0001", "12345");
    Conta contaNova02 = new Conta(1L, "0001", "12345");
    
    @Test
    public void deveInstaciarDoisObjetosDoMesmoTipo() {
        assertEquals(contaNova01, contaNova02);
    }

    @Test
    void deveInstanciarContaNovaComSaldoZerado() {
        assertEquals(contaNova01.getSaldo(), 0.0);
        assertEquals(contaNova02.getSaldo(), 0.0);
    }

    @Test
    void deveInstaciarContaNovaAtivada() {
        assertTrue(contaNova01.isAtivo());
    }

    // * Métodos
    // * Método - Depositar

    Conta contaDepositar01 = new Conta(1L, "002D", "1234D");

    @Test
    void deveRealizarDepositoComSucesso() {
        var valorDeposito = 1000.0;
        contaDepositar01.depositar(valorDeposito);
        assertEquals(contaDepositar01.getSaldo(), valorDeposito);
    }
    
    @Test
    void deveRejeitarDepositoComValorNegativo_menorQueZero() {
        var valorDepositoNegativo = -1.0;
        
        assertThrows(RuntimeException.class, () -> {
            contaDepositar01.depositar(valorDepositoNegativo);
        }, "Depósito não pode ter valor negativo.");
    }
    
    @Test
    void deveRejeitarDepositoEmContaDesativada() {
        contaDepositar01.setAtivo(false);
        assertThrows(RuntimeException.class, () -> {
            contaDepositar01.depositar(500.0);
        }, "Conta desativada não pode receber depositos.");
    }

    // * Método - Sacar

    Conta contaSacar01 = new Conta(1L, "002C", "1234C");
    
    @Test
    void deveRelizarSaqueComSucesso() {
        contaSacar01.depositar(1000.0);
        contaSacar01.sacar(500.0);
        assertEquals(contaSacar01.getSaldo(), 500.0);
    }
    
    // @Test
    // void deveRejeitarSaqueComValoresNegativos() {
    //     var valorSaqueNegativo = -5.0;
    //     contaSacar01.depositar(1000.0);
    //     contaSacar01.sacar(valorSaqueNegativo);

    //     assertThrows(RuntimeException.class, () -> {
    //         contaDepositar01.depositar(valorSaqueNegativo);
    //     }, "Depósito não pode ter valor negativo.");
    // }

}
