package com.example.pruebarecyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pruebarecyclerview.clases.Tarea;

public class Detalle_Tarea extends AppCompatActivity {

    ImageView img_tarea;
    TextView txt_nombre_tarea, txt_descripcion_tarea, txt_estado_tarea, txt_categoria_tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tarea);

        Tarea tarea = getIntent().getParcelableExtra("tarea");

        img_tarea = findViewById(R.id.img_tarea);
        txt_nombre_tarea = findViewById(R.id.txt_nombre_tarea);
        txt_descripcion_tarea = findViewById(R.id.txt_descripcion_tarea);
        txt_estado_tarea = findViewById(R.id.txt_estado_tarea);
        txt_categoria_tarea = findViewById(R.id.txt_categoria_tarea);

        if (tarea != null) {
            txt_nombre_tarea.setText(tarea.getNombre());
            txt_descripcion_tarea.setText(tarea.getDescripcion());
            txt_estado_tarea.setText(tarea.getEstado() ? "Completada" : "Pendiente");
            txt_estado_tarea.setTextColor(getResources().getColor(tarea.getEstado() ? R.color.green : R.color.red));
            if (tarea.getCategoria().equals("Deportes")) {
                img_tarea.setImageDrawable(getResources().getDrawable(R.drawable.deportes));
            } else if (tarea.getCategoria().equals("Compras")) {
                img_tarea.setImageDrawable(getResources().getDrawable(R.drawable.compras));
            } else if (tarea.getCategoria().equals("Estudios")) {
                img_tarea.setImageDrawable(getResources().getDrawable(R.drawable.estudios));
            } else if (tarea.getCategoria().equals("Hogar")) {
                img_tarea.setImageDrawable(getResources().getDrawable(R.drawable.hogar));
            } else {
            img_tarea.setImageDrawable(getResources().getDrawable(tarea.getEstado() ? R.drawable.tarea_completada : R.drawable.tareas_pendientes));
            }
            txt_categoria_tarea.setText(tarea.getCategoria());
        }
    }
}