package com.example.rickandmortycompose.network

import com.example.rickandmortycompose.models.Characters
import retrofit2.http.GET

interface RickAndMortyCharacterApi {

    @GET("character/")
    suspend fun getCharacters(): Characters

}