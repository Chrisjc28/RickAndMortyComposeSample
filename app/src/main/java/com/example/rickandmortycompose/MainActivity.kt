package com.example.rickandmortycompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmortycompose.network.Network
import com.example.rickandmortycompose.network.RickAndMortyCharacterApi
import com.example.rickandmortycompose.repositories.RickAndMortyCharacterRepo
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import com.example.rickandmortycompose.ui.theme.RickAndMortyList
import com.example.rickandmortycompose.utils.CoroutineContextProviderImpl
import com.example.rickandmortycompose.viewmodels.CharacterViewModel

class MainActivity : AppCompatActivity() {

    private val coroutineContextProvider = CoroutineContextProviderImpl()
    private val rickAndMortyCharacterApi =
        Network.createService(RickAndMortyCharacterApi::class.java)
    private val rickAndMortyRepo: RickAndMortyCharacterRepo =
        RickAndMortyCharacterRepo(coroutineContextProvider, rickAndMortyCharacterApi)
    private val characterViewModel: CharacterViewModel =
        CharacterViewModel(rickAndMortyRepo, coroutineContextProvider)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowCharacters(characterViewModel)
        }
    }
}

@Composable
fun ShowCharacters(characterViewModel: CharacterViewModel) {
    RickAndMortyComposeTheme {
        RickAndMortyList(characterViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}