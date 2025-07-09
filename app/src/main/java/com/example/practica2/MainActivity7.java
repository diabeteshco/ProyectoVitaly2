package com.example.practica2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {
    EditText edtEdad, edtHorasSemanales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtEdad = findViewById(R.id.edtEdad);
        edtHorasSemanales = findViewById(R.id.edtHorasSemanales);
    }
    public void calcularSueno(View view) {

        String edadStr = edtEdad.getText().toString();
        String horasStr = edtHorasSemanales.getText().toString();

        if (edadStr.isEmpty() || horasStr.isEmpty()) {
            if (edadStr.isEmpty()) edtEdad.setError("Ingresa tu edad");
            if (horasStr.isEmpty()) edtHorasSemanales.setError("Ingresa horas semanales");
            return;
        }

        int edad = Integer.parseInt(edadStr);
        float horasSemanales = Float.parseFloat(horasStr);
        float promedioDiario = horasSemanales / 7;

        String mensaje = evaluarSueno(edad, promedioDiario);

        Intent intent = new Intent(this, MainActivity8.class);
        intent.putExtra("mensajeSueno", mensaje);
        startActivity(intent);
    }

    private String evaluarSueno(int edad, float promedio) {
        if (edad <= 0) return "Edad inválida";

        if (edad <= 3) { // 0-3 años
            if (promedio >= 14 && promedio <= 17) return "Estás en el rango permitido";
        } else if (edad <= 11) { // 4-11 años
            if (promedio >= 9 && promedio <= 11) return "Estás en el rango permitido";
        } else if (edad <= 17) { // 12-17 años
            if (promedio >= 8 && promedio <= 10) return "Estás en el rango permitido";
        } else if (edad <= 64) { // 18-64 años
            if (promedio >= 7 && promedio <= 9) return "Estás en el rango permitido";
        } else { // 65+
            if (promedio >= 7 && promedio <= 8) return "Estás en el rango permitido";
        }

        if (promedio < 7) return "Debes descansar más horas o vas a enfermar";
        return "Estás durmiendo demasiado, consulta con un especialista";
    }
    }
