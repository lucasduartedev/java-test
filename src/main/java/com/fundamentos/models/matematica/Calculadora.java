package com.fundamentos.models.matematica;

public class Calculadora {

    public Double somar(Double n1, Double n2) {
        return n1 + n2;
    }

    public Double subtrair(Double n1, Double n2) {
        return n1 - n2;
    }

    public Double multiplicar(Double n1, Double n2) {
        return n1 * n2;
    }

    public Double dividir(Double n1, Double n2) {
        if (n1.equals(0D) || n2.equals(0D)) throw new ArithmeticException();
        return n1 / n2;
    }

}
