package com.example.practica2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OpcionAdapter extends RecyclerView.Adapter<OpcionAdapter.ViewHolder> {

    private List<Opcion> opciones;

    public OpcionAdapter(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Opcion opcion = opciones.get(position);
        holder.textView.setText(opcion.getTitulo());
        holder.imageView.setImageResource(opcion.getImagen());
        holder.btnVer.setOnClickListener(v -> {
            String mensaje = "";
            switch (opcion.getTitulo()) {
                case "Consumo de Agua":
                    mensaje = "Debes consumir mínimamente 3 litros de agua";
                    break;
                case "Actividad Física":
                    mensaje = "Hoy debes hacer una caminata mínima de 10 minutos";
                    break;
                case "Horas de Sueño":
                    mensaje = "Debes dormir al menos 6 horas sin pausa";
                    break;
            }

            Intent intent = new Intent(v.getContext(), DetalleActivivity.class);
            intent.putExtra("mensaje", mensaje);
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return opciones.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        Button btnVer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewItem);
            textView = itemView.findViewById(R.id.textViewItem);
            btnVer = itemView.findViewById(R.id.btnVer);
        }
    }
}
