package com.example.rickandmortycompose.repositories

import android.util.Log
import com.example.rickandmortycompose.network.RickAndMortyCharacterApi
import com.example.rickandmortycompose.state.AppState
import com.example.rickandmortycompose.utils.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RickAndMortyCharacterRepo(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val rickAndMortyCharacterApi: RickAndMortyCharacterApi
) {

    private val LOG_TAG = RickAndMortyCharacterRepo::class.java.simpleName

    fun getCharacters(): Flow<AppState> {
        return flow {
            emit(AppState.Loading)
            Log.i(LOG_TAG, "LOADING")
           val characters = rickAndMortyCharacterApi.getCharacters()
            emit(AppState.Data(characters))
            Log.i(LOG_TAG, "Got characters $characters")
        }.catch { e ->
            emit(AppState.Error(e))
            Log.i(LOG_TAG, "Error $e")
        }.flowOn(coroutineContextProvider.io())
    }
}