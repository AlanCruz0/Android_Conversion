package com.example.conversion.models;

public class Fahrenheit extends Grado{
    public Fahrenheit(double valor) {
        super(valor);
    }

    public Fahrenheit(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Fahrenheit parse(Celsius c) {
        return new Fahrenheit((c.getValor()*9/5)+32, "F");
    }

    public Fahrenheit parse(Kelvin k) {
        return new Fahrenheit((k.getValor()-273.15)*9/5+32, "F");
    }
}
