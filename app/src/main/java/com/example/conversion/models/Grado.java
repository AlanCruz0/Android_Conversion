package com.example.conversion.models;

public class Grado {
    private Double valor;
    private String unidad;

    public Grado(double valor) {
        this.valor = valor;
    }

    public Grado(Double valor, String unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
