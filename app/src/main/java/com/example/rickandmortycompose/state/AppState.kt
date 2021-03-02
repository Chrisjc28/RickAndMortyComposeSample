package com.example.rickandmortycompose.state

import com.example.rickandmortycompose.models.RickAndMortyData

sealed class AppState {
    object Loading : AppState()
    data class Data<out T: RickAndMortyData>(val data: T): AppState()
    data class Error(val error: Throwable): AppState()
}
