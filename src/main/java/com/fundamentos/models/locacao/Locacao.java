package com.fundamentos.models.locacao;

import java.time.LocalDate;
import java.time.LocalTime;

public class Locacao {

    private LocalDate dataRetirada;
    private LocalTime horaRetirada;
    private LocalDate dataDevolucao;
    private LocalTime horaDevolucao;
    private Double valorLocacao;

    public Locacao(LocalDate dataRetirada, LocalTime horaRetirada, LocalDate dataDevolucao, LocalTime horaDevolucao,
            Double valorLocacao) {
        this.dataRetirada = dataRetirada;
        this.horaRetirada = horaRetirada;
        this.dataDevolucao = dataDevolucao;
        this.horaDevolucao = horaDevolucao;
        this.valorLocacao = valorLocacao;
    }

    // * Getters and Setters
    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalTime getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(LocalTime horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalTime getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(LocalTime horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }
    
    
    
}
