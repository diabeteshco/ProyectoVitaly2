package com.example.practica2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    EditText edt2, edt3, edt4, edt5, edt6, edt7, edt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
            edt2 = findViewById(R.id.edt2);
            edt3 = findViewById(R.id.edt3);
            edt4 = findViewById(R.id.edt4);
            edt5 = findViewById(R.id.edt5);
            edt6 = findViewById(R.id.edt6);
            edt7 = findViewById(R.id.edt7);
            edt8 = findViewById(R.id.edt8);

    }

    public void inicio(View view) {
        Intent i= new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(i);
    }

    public void calcularagua(View view) {
        try {
            // Sumamos todos los valores ingresados
            float lunes = Float.parseFloat(edt2.getText().toString());
            float martes = Float.parseFloat(edt3.getText().toString());
            float miercoles = Float.parseFloat(edt4.getText().toString());
            float jueves = Float.parseFloat(edt5.getText().toString());
            float viernes = Float.parseFloat(edt6.getText().toString());
            float sabado = Float.parseFloat(edt7.getText().toString());
            float domingo = Float.parseFloat(edt8.getText().toString());

            float promedio = (lunes + martes + miercoles + jueves + viernes + sabado + domingo) / 7;

            String mensaje;
            if (promedio < 1.5) {
                mensaje = "El consumo es demasiado bajo, hidrátate.";
            } else if (promedio >= 1.5 && promedio < 3) {
                mensaje = "Debes mejorar tu consumo de agua.";
            } else {
                mensaje = "Tu consumo es el ideal, ¡sigue así!";
            }

            // Enviamos el mensaje a la nueva Activity
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("mensajeAgua", mensaje);
            startActivity(intent);

        } catch (Exception e) {
            // Manejo si algún campo está vacío o error al convertir
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("mensajeAgua", "Por favor ingresa todos los datos correctamente.");
            startActivity(intent);
        }


    }
}