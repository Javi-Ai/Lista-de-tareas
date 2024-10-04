package com.example.pruebarecyclerview.adaptadores;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebarecyclerview.Detalle_Tarea;
import com.example.pruebarecyclerview.R;
import com.example.pruebarecyclerview.clases.Tarea;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TareaAdaptador extends RecyclerView.Adapter<TareaAdaptador.ViewHolder> {

    private List<Tarea> datos;

    public TareaAdaptador(List<Tarea> datos){
        this.datos = datos;
    }

    @NonNull
    @Override
    public TareaAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaAdaptador.ViewHolder holder, int position) {
        Tarea dato = datos.get(position);
        holder.bind(dato);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Detalle_Tarea.class);
                intent.putExtra("tarea", dato);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView lyt_tarea;
        TextView txt_nombre_tarea, txt_descripcion_tarea, txt_estado_tarea, txt_categoria_tarea;
        ImageView img_tarea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombre_tarea = itemView.findViewById(R.id.txt_nombre_tarea);
            txt_descripcion_tarea = itemView.findViewById(R.id.txt_descripcion_tarea);
            txt_estado_tarea = itemView.findViewById(R.id.txt_estado_tarea);
            img_tarea = itemView.findViewById(R.id.img_tarea);
            lyt_tarea = itemView.findViewById(R.id.lyt_tarea);
        }

        public void bind(Tarea dato){
            txt_nombre_tarea.setText(dato.getNombre());
            txt_estado_tarea.setText(dato.getEstado() ? "Completado" : "Pendiente");
            lyt_tarea.setBackgroundColor(itemView.getResources().getColor(dato.getEstado() ? R.color.green : R.color.red));
            if (dato.getCategoria().equals("Deportes")) {
                img_tarea.setImageDrawable(itemView.getResources().getDrawable(R.drawable.deportes));
            } else if (dato.getCategoria().equals("Compras")) {
                img_tarea.setImageDrawable(itemView.getResources().getDrawable(R.drawable.compras));
            } else if (dato.getCategoria().equals("Estudios")) {
                img_tarea.setImageDrawable(itemView.getResources().getDrawable(R.drawable.estudios));
            } else if (dato.getCategoria().equals("Hogar")) {
                img_tarea.setImageDrawable(itemView.getResources().getDrawable(R.drawable.hogar));
            } else {
            img_tarea.setImageDrawable(itemView.getResources().getDrawable(dato.getEstado() ? R.drawable.tarea_completada : R.drawable.tareas_pendientes));}
        }
    }

}
