package com.example.conversion.models;

public class Kelvin extends Grado{
    public Kelvin(double valor) {
        super(valor);
    }

    public Kelvin(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Kelvin parse(Celsius c) {
        return new Kelvin(c.getValor() + 273.15, "C");
    }

    public Kelvin parse(Fahrenheit f) {
        return new Kelvin((f.getValor()-32)*5/9+273.15, "F");
    }
}
