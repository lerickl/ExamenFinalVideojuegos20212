package com.example.finalvideojuegos20212.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalvideojuegos20212.R;
import com.example.finalvideojuegos20212.entities.Libro;
import com.example.finalvideojuegos20212.itemDetalle;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterLibro extends RecyclerView.Adapter<AdapterLibro.AdapterLibroViewHolder> {
    List<Libro> data;
    View view;
    public AdapterLibro(List<Libro> data)
    {
        this.data = data;
    }
    @NonNull
    @Override
    public AdapterLibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        //PokemonViewHolder pokemonViewHolder = new PokemonViewHolder(view);

        return new AdapterLibroViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterLibroViewHolder holder, int position) {


        TextView nombre = holder.itemView.findViewById(R.id.NombreItem);
        ImageView Imagen = holder.itemView.findViewById(R.id.profile_image);

        Libro libro = data.get(position);

        String urlImg="https://upn.lumenes.tk";
        nombre.setText(libro.nombre);
        Picasso.get()
                .load(urlImg+libro.imagen_url)
                .into((ImageView) holder.itemView.findViewById(R.id.profile_image));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, itemDetalle.class);

                intent.putExtra("ID",libro.id);
                intent.putExtra("nombre",libro.nombre);

                intent.putExtra("url",urlImg+libro.imagen_url);
                intent.putExtra("localTienda1",libro.tienda_1);
                intent.putExtra("localTienda2",libro.tienda_2);
                intent.putExtra("localTienda3",libro.tienda_3);
                intent.putExtra("vistas",libro.vistas);
                intent.putExtra("Fecha",libro.fecha_de_estreno);


                context.startActivity(intent);
                Log.e("Clic","CAR"+ libro.nombre);
            }
        });

        // DetallePokemon(position);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class AdapterLibroViewHolder extends RecyclerView.ViewHolder{

        public AdapterLibroViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



}
