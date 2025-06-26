package com.example.practica2;

import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.widget.Toolbar;
import android.widget.EditText;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    TextView txt1, txt2;
 EditText edt1;
    Paint Paint;
    String nombre;
    Toolbar t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            txt1 = findViewById(R.id.txt1);
            Toolbar t =findViewById(R.id.mitoolbar);
            t.setTitle("");
            setSupportActionBar(t);

            TextView textView = findViewById(R.id.txt2);
           textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        edt1 =findViewById(R.id.edt1);

    }


    public void login(View view) {
        nombre = edt1.getText().toString();
        Intent i= new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra("Nombre",nombre);
        startActivity(i);


    }


    public void contrasolvid(View view) {
        String url = "https://workspace.vitaly.es/workspace/password-recovery";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void registrarse(View view) {
        String url = "https://workspace.vitaly.es/login";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}

