package com.example.conversion.models;

public class Celsius extends Grado{
    public Celsius(double valor) {
        super(valor);
    }

    public Celsius(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Celsius parse(Fahrenheit f) {
        return new Celsius((f.getValor()- 32)*5/9, "F");
    }

    public Celsius parse(Kelvin k) {
        return new Celsius(k.getValor() - 273.15, "K");
    }
}
