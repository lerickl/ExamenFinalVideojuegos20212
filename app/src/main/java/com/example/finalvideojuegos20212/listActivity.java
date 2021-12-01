package com.example.finalvideojuegos20212;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalvideojuegos20212.adapters.AdapterLibro;
import com.example.finalvideojuegos20212.entities.Libro;
import com.example.finalvideojuegos20212.services.item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class listActivity extends Activity {
    private FloatingActionButton Agregar;
    public static RecyclerView listaActivity;

    private static String url ="https://upn.lumenes.tk/pokemons/n00033222";
    static  String urlss="https://upn.lumenes.tk/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        listaActivity=findViewById(R.id.recyclerList);
        listaActivity.setHasFixedSize(true);
        listaActivity.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlss)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        item service = retrofit.create(item.class);
        service.all().enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call, retrofit2.Response<List<Libro>> response) {
                Log.i("MAIN_APP", String.valueOf(response.code()));
                AdapterLibro adapter = new AdapterLibro(response.body());
                listaActivity.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                Log.e("MAIN_APP", "No se puede establecer comunicación con el API");
                Log.e("MAIN_APP",  String.valueOf(t.toString()));
            }
        });
        //ObtenerID();
        // ClicAgregar();
        //PeticonGet();
    }

}
