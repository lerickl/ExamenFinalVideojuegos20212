package com.example.finalvideojuegos20212;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnmispokemons= findViewById(R.id.Agregar);
        Log.i("data","true");
        btnmispokemons.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent;

                intent = new Intent(getApplicationContext(), listActivity.class);
                startActivity(intent);
            }
        });
    }
}