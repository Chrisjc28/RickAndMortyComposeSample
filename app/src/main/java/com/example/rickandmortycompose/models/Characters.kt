package com.example.rickandmortycompose.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Characters(
    @SerialName("info")
    val info: Info,
    @SerialName("results")
    val results: List<Result>
): RickAndMortyData