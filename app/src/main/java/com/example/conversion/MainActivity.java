package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.conversion.models.Celsius;
import com.example.conversion.models.Fahrenheit;
import com.example.conversion.models.Grado;
import com.example.conversion.models.Kelvin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Celsius celsius = new Celsius(0.0, "C");
        celsius.setValor(12.0);
        Fahrenheit fahrenheit = new Fahrenheit(32.0, "F");
        Kelvin kelvin = new Kelvin(273.15, "K");

        Celsius valor = celsius.parse(fahrenheit);

        System.out.println(valor);
    }

}