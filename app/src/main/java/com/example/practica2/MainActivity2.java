package com.example.practica2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    TextView txt3;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Toolbar toolbar = findViewById(R.id.mitoolbar2);
        setSupportActionBar(toolbar);


        txt3 = findViewById(R.id.txt3);
        name = getIntent().getStringExtra("Nombre");
        txt3.setText("Bienvenid@:" + name);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Opcion> listaOpciones = new ArrayList<>();
        listaOpciones.add(new Opcion("Consumo de Agua", R.drawable.agua));
        listaOpciones.add(new Opcion("Actividad Física", R.drawable.ejercicio));
        listaOpciones.add(new Opcion("Horas de Sueño", R.drawable.sueno));

        OpcionAdapter adapter = new OpcionAdapter(listaOpciones);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.op1) {
            Toast.makeText(MainActivity2.this, "Opción 1 seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.op2) {
            Toast.makeText(MainActivity2.this, "Opción 2 seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ir(View view) {
        Intent i= new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(i);
    }


    public void ira(View view) {
        Intent i= new Intent(MainActivity2.this, MainActivity5.class);
        startActivity(i);
            }

    public void irb(View view) {
        Intent i= new Intent(MainActivity2.this, MainActivity7.class);
        startActivity(i);
    }
}

