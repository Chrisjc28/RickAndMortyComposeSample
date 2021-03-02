package com.example.rickandmortycompose.ui.theme

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.rickandmortycompose.models.Characters
import com.example.rickandmortycompose.models.RickAndMortyData
import com.example.rickandmortycompose.state.AppState
import com.example.rickandmortycompose.viewmodels.CharacterViewModel

@Composable
fun RickAndMortyList(characterViewModel: CharacterViewModel) {
    val context = LocalContext.current

    characterViewModel.loadCharacters()
    val characters = characterViewModel.character.observeAsState(AppState.Loading)

    return when (characters.value) {
        is AppState.Data<RickAndMortyData> -> {
            MaterialTheme {
                val results =
                    ((characters.value as AppState.Data<RickAndMortyData>).data as Characters).results
                LazyColumn {
                    items(results) { result ->
                        CreateCharactersCard(result) {
                            Toast.makeText(context, result.name, Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        }
        is AppState.Error -> {
            Text(text = (characters.value as AppState.Error).error.localizedMessage ?: "")
        }
        AppState.Loading -> {
            Column {
                CircularProgressIndicator(color = MaterialTheme.colors.primary)
            }
        }
    }
}