package com.example.rickandmortycompose.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Info(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("pages")
    val pages: Int,
    @SerialName("prev")
    val prev: String
): RickAndMortyData