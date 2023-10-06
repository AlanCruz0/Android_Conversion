package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.conversion.models.Celsius;
import com.example.conversion.models.Fahrenheit;
import com.example.conversion.models.Grado;
import com.example.conversion.models.Kelvin;

public class MainActivity extends AppCompatActivity {
    EditText etxtvalor;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private TextView textViewResult;
    private Button buttonConvert;
    String[] unidades = {"Celsius", "Fahrenheit", "Kelvin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxtvalor = (EditText) findViewById(R.id.editTextNumber);
        Spinner spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        Spinner spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert = findViewById(R.id.buttonConvert);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        buttonConvert.setOnClickListener(v -> {
            String inputValue = etxtvalor.getText().toString();
            String unitFrom = spinnerFrom.getSelectedItem().toString();
            String unitTo = spinnerTo.getSelectedItem().toString();

            Grado resultado = new Grado(Double.parseDouble(inputValue) , unitFrom);
            resultado = convertUnits(resultado, unitTo);
            textViewResult.setText("Resultado: " + resultado.getValor() + " " + resultado.getUnidad());
        });
    }
    private Grado convertUnits(Grado value, String unitTo) {
        Fahrenheit f = new Fahrenheit(0.0);
        Celsius c = new Celsius(0.0);
        Kelvin k = new Kelvin(0.0);

        if (value.getUnidad().equals("Celsius")) {
            Celsius obj = new Celsius(value.getValor(), value.getUnidad());
            if (unitTo.equals("Fahrenheit")){
                return f.parse(obj);
            }
            else if (unitTo.equals("Kelvin")){
                return k.parse(obj);
            }
            return obj;
        } else if (value.getUnidad().equals("Fahrenheit")) {
            Fahrenheit obj = new Fahrenheit(value.getValor(), value.getUnidad());
            if (unitTo.equals("Celsius")){
                return c.parse(obj);
            }
            else if (unitTo.equals("Kelvin")){
                return k.parse(obj);
            }
            return obj;
        } else if (value.getUnidad().equals("Kelvin")) {
            Kelvin obj = new Kelvin(value.getValor(), value.getUnidad());
            if (unitTo.equals("Celsius")){
                return c.parse(obj);
            }
            else if (unitTo.equals("Fahrenheit")){
                return f.parse(obj);
            }
            return obj;
        }
        return value;
    }

}