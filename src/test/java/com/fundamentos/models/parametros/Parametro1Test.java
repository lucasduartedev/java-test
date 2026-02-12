package com.fundamentos.models.parametros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        Double delta = 2D;

        assertEquals(expectedN, actual, delta);
    }

    public static Stream<Arguments> testDivisaoInputParameters() {
        return Stream.of(
            Arguments.of(6D, 2D, 3D),
            Arguments.of(71D, 14D, 5.07D),
            Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }

    @DisplayName("Testa a divisão entre dois núemro com CSV String")
    @ParameterizedTest
    @CsvSource({
        "9, 3, 3",
        "10, 2, 5",
        "15, 3, 5",
        "20, 3, 6.66666"
    })
    void testaDivisaoDeDoisNumerosComCsvString(double n1, double n2, double expectedN) {
        Double actual = calculadora.dividir(n1, n2);

        Double delta = 2D;

        assertEquals(expectedN, actual, delta);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Senna", "Formula", "Futebol"})
    void testComValueSource(String nome) {
        System.out.println(nome);
        assertNotNull(nome);
    }


}
