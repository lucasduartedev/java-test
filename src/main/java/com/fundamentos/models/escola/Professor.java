package com.fundamentos.models.escola;

public class Professor extends Pessoa{
    
    private String materia;
    private Double salario;

    public Professor(String nome) {
        super(nome);
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

}
