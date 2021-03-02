package com.example.rickandmortycompose.viewmodels

import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycompose.repositories.RickAndMortyCharacterRepo
import com.example.rickandmortycompose.state.AppState
import com.example.rickandmortycompose.utils.CoroutineContextProvider
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val rickAndMortyCharacterRepo: RickAndMortyCharacterRepo,
    private val coroutineContextProvider: CoroutineContextProvider) :
    ViewModel() {

    private var _character: MutableLiveData<AppState> = MutableLiveData()
    val character: LiveData<AppState> = _character

    @Composable
    fun loadCharacters() {
        viewModelScope.launch (coroutineContextProvider.io()) {
            rickAndMortyCharacterRepo.getCharacters().collect {
                _character.postValue(it)
            }
        }
    }
}