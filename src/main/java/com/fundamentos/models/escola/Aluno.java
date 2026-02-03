package com.fundamentos.models.escola;

import java.util.List;

public class Aluno extends Pessoa{
    
    private List<Double> notas;

    public Aluno(String nome) {
        super(nome);
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

}
