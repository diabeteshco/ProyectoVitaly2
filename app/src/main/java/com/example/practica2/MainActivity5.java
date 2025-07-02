package com.example.practica2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    EditText edtMinutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        edtMinutos = findViewById(R.id.edtMinutos);
    }

    public void calcularActividad(View view) {
        String texto = edtMinutos.getText().toString();
        if (texto.isEmpty()) {
            edtMinutos.setError("Ingresa los minutos caminados esta semana");
            return;
        }

        int minutos = Integer.parseInt(texto);
        String mensaje;

        if (minutos < 70) {
            mensaje = "Tu actividad física no es la ideal, ¡a caminar!";
        } else if (minutos <= 35) {
            mensaje = "Tu actividad física está regular.";
        } else {
            mensaje = "Tu actividad física es la correcta, ¡sigue así!";
        }

        Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
        intent.putExtra("resultado", mensaje);
        startActivity(intent);
    }

    }
