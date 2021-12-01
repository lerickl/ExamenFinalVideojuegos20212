package com.example.finalvideojuegos20212;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalvideojuegos20212.entities.Libro;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class itemDetalle extends Activity {
    private static String url = "https://upn.lumenes.tk/pokemones/{id}";
    private Libro libro;
    private ImageView portada;
    private TextView nombre;
    private TextView vistas;
    private TextView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detalle);
        nombre = findViewById(R.id.NombreL);
        vistas= findViewById(R.id.Vistas);
        fecha=findViewById(R.id.FechaEstreno);

        int id = getIntent().getIntExtra("ID", 0);
        String imagen = getIntent().getStringExtra("url");
        String nombres = getIntent().getStringExtra("nombre");
        String Vista=getIntent().getStringExtra("vistas");
        String fech=getIntent().getStringExtra("Fecha");
        String locTienda1=getIntent().getStringExtra("localTienda1");
        String locTienda2=getIntent().getStringExtra("localTienda1");
        String locTienda3=getIntent().getStringExtra("localTienda1");
        vistas.setText(Vista);
        fecha.setText(fech);

        Picasso.get()
                .load(imagen)
                .into((ImageView) findViewById(R.id.avatar));
        nombre.setText(nombres);

        //DetalleLibro(id);
        //ObtenerId();

        Button btnmispokemons= findViewById(R.id.btnTienda1);
        Log.i("data","true");
        btnmispokemons.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Context context = view.getContext();
                Intent intent = new Intent(context, MapsActivity.class);


                intent.putExtra("nombre",nombres);
                intent.putExtra("ubic",locTienda1);

                startActivity(intent);
            }
        });
        Button btnmispokemons2= findViewById(R.id.btnTienda2);
        Log.i("data","true");
        btnmispokemons2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Context context = view.getContext();
                Intent intent = new Intent(context, MapsActivity.class);


                intent.putExtra("nombre",nombres);
                intent.putExtra("ubic",locTienda2);

                startActivity(intent);
            }
        });
        Button btnmispokemon3= findViewById(R.id.btnTienda3);
        Log.i("data","true");
        btnmispokemon3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Context context = view.getContext();
                Intent intent = new Intent(context, MapsActivity.class);


                intent.putExtra("nombre",nombres);
                intent.putExtra("ubic",locTienda3);

                startActivity(intent);
            }
        });
    }




}
