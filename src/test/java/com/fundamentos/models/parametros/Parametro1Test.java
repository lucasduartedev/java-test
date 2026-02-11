package com.fundamentos.models.parametros;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.fundamentos.models.matematica.Calculadora;

public class Parametro1Test {

    private Calculadora calculadora;

    @BeforeEach
    void abeforeEachMthod() {
        calculadora = new Calculadora();
    }

    @DisplayName("Testa a divisão entre dois números")
    @ParameterizedTest
    @MethodSource("testDivisaoInputParameters")
    void testaDivisaoDeDoisNumeros(double n1, double n2, double expectedN) {
        Double actual = calculadora.dividir(n1, n2);

        assertEquals(expectedN, actual, 2D);
    }

    public static Stream<Arguments> testDivisaoInputParameters() {
        return Stream.of(
            Arguments.of(6D, 2D, 3D),
            Arguments.of(71D, 14D, 5.07D),
            Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }

}
