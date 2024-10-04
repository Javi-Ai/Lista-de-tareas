package com.example.pruebarecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebarecyclerview.adaptadores.TareaAdaptador;
import com.example.pruebarecyclerview.clases.Tarea;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv_tareas;
    List<Tarea> listaTareas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_tareas = findViewById(R.id.rcv_tareas);

        listaTareas.add(new Tarea("Jugar Fútbol", "Partido amistoso con los amigos", false, "Deportes"));
        listaTareas.add(new Tarea("Comprar víveres", "Ir al supermercado a comprar frutas y verduras", true, "Compras"));
        listaTareas.add(new Tarea("Estudiar para examen", "Repasar el material para el examen de matemáticas", false, "Estudios"));
        listaTareas.add(new Tarea("Limpiar la casa", "Barrer, trapear y organizar las habitaciones", true, "Hogar"));
        listaTareas.add(new Tarea("Ir al gimnasio", "Entrenamiento de fuerza y cardio", false, "Deportes"));
        listaTareas.add(new Tarea("Comprar ropa", "Ir al centro comercial para comprar ropa de invierno", true, "Compras"));
        listaTareas.add(new Tarea("Leer un libro", "Terminar el capítulo 5 del libro de historia", false, "Estudios"));
        listaTareas.add(new Tarea("Cocinar la cena", "Preparar una cena saludable con ensalada y pollo", true, "Hogar"));



        rcv_tareas.setLayoutManager(new LinearLayoutManager(this));
        rcv_tareas.setAdapter(new TareaAdaptador(listaTareas));


    }
}