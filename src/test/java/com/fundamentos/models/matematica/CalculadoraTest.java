package com.fundamentos.models.matematica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setup() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Testa a soma entre dois números")
    void testaSomaDeDoisNumeros() {
        Double actual = calculadora.somar(3D, 6.3D);
        Double expected = 9.3D;
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Testa a subtração entre dois números")
    void testaSubtracaoDeDoisNumeros() {
        Double actual = calculadora.subtrair(9D, 3D);
        Double expected = 6D;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testa a multiplicação entre dois números")
    void testaMultiplicacaoDeDoisNumeros() {
        Double actual = calculadora.multiplicar(2D, 3D);
        Double expected = 6D;
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Testa a divisão entre dois números")
    void testaDivisaoDeDoisNumeros() {
        Double actual = calculadora.dividir(10D, 2D);
        Double expected = 5D;
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Testa a divisão com divisor igual a zero")
    void testaDivisaoPorZero_01_DeveLancarException() {
        Double n1 = 10D;
        Double n2 = 0D;
        
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(n1, n2);
        });
    }
    
    @Test
    @DisplayName("Testa a divisão com dividendo igual a zero")
    void testaDivisaoPorZero_02_DeveLancarException() {
        Double n1 = 0D;
        Double n2 = 10D;

        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(n1, n2);
        });
    }
    
}
