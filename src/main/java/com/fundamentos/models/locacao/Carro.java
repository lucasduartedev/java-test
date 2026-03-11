package com.fundamentos.models.locacao;

public class Carro {

    private String modelo;
    private String chassi;
    private String cor;
    private String km;
    private Double valorDiaria;

    public Carro(String modelo, String chassi, String cor, String km, Double valorDiaria) {
        this.modelo = modelo;
        this.chassi = chassi;
        this.cor = cor;
        this.km = km;
        this.valorDiaria = valorDiaria;
    }

    // * Getters and Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    
    
}
