package com.example.finalvideojuegos20212.services;

import com.example.finalvideojuegos20212.entities.Libro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface item {
    @GET("peliculas/n00033222")
    Call<List<Libro>> all();
}
