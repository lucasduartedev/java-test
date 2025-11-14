package com.fundamentos.models.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @Test
    void deveChecarSePropriedadesNaoSaoNulas() {
        assertNotNull(contaNova01.getId());
        assertNotNull(contaNova01.getAgencia());
        assertNotNull(contaNova01.getNumero());
        assertNotNull(contaNova01.isAtivo());
        assertNotNull(contaNova01.getSaldo());
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
    Conta contaSacarDesativada02 = new Conta(2L, "003C", "123CC");
    
    @Test
    void deveRelizarSaqueComSucesso() {
        contaSacar01.depositar(1000.0);
        contaSacar01.sacar(500.0);
        assertEquals(contaSacar01.getSaldo(), 500.0);
    }
    
    @Test
    void deveRejeitarSaqueComValoresNegativos() {
        var valorSaqueNegativo = -1.0;

        assertThrows(RuntimeException.class, () -> {
            contaSacar01.sacar(valorSaqueNegativo);
        }, "Saque não pode ter valor negativo.");
        
    }

    @Test
    void deveRejeitarSaqueEmContaDesativada() {
        contaSacarDesativada02.setAtivo(false);
        assertThrows(RuntimeException.class, () -> {
            contaSacarDesativada02.sacar(250.0);
        }, "Conta desativada não pode realizar Saque");
    }

    // * Método - Transferência
    Conta contaTransferencia01 = new Conta(5L, "003T", "1234T");
    Conta contaTransferencia02 = new Conta(6L, "003T", "1234T");
    
    @Test
    void deveRealizarTransferenciaComSucesso() {
        contaTransferencia01.depositar(1000.0);
        contaTransferencia01.tranferir(contaTransferencia02, 500.0);
        
        assertEquals(contaTransferencia01.getSaldo(), 500.0);
        assertEquals(contaTransferencia02.getSaldo(), 500.0);
    }

    @Test
    void deveRejeitarTransferenciaComValorNegativo() {
        contaTransferencia01.depositar(1000.0);
        assertThrows( RuntimeException.class, () -> {
            contaTransferencia01.tranferir(contaTransferencia02, -1.0);
        }, "Transferência com valor negativo não autorizado.");
    }
    
    @Test
    void deveRejeitarTransferenciaSeContaOrigemEstaDesativada() {
        contaTransferencia01.setAtivo(false);
        assertThrows( RuntimeException.class, () -> {
            contaTransferencia01.tranferir(contaTransferencia02, 1.0);
        }, "Não autorizado, conta origem está desativada.");
    }
    
    @Test
    void deveRejeitarTransferenciaSeContaDestinoEstaDesativada() {
        contaTransferencia02.setAtivo(false);
        assertThrows( RuntimeException.class, () -> {
            contaTransferencia01.tranferir(contaTransferencia02, 1.0);
        }, "Não autorizado, conta destino está desativada.");
    }

    @Test
    void deveLancarErroComParametrosNulos_conta() {
        contaTransferencia01.depositar(500.0);
        assertThrows( RuntimeException.class, () -> {
            contaTransferencia01.tranferir(null, 1.0);
        }, "Não autorizado, conta destino nula.");
    }
    
    @Test
    void deveLancarErroComParametrosNulos_valor() {
        contaTransferencia01.depositar(500.0);
        assertThrows( RuntimeException.class, () -> {
            contaTransferencia01.tranferir(contaTransferencia02, null);
        }, "Não autorizado, valor da transferência nula.");
    }

    Conta contaTransferencia_Desativada03 = new Conta(7L, "003T", "1234T");
    Conta contaTransferencia_DestinoDesativada04 = new Conta(8L, "003T", "1234T");


    
}
