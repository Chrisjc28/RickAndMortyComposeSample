package com.example.rickandmortycompose.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Location(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)