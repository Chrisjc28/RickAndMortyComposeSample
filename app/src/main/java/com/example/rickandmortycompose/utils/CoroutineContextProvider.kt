package com.example.rickandmortycompose.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    fun io(): CoroutineContext
    fun computation(): CoroutineContext
    fun ui(): CoroutineContext
}

class CoroutineContextProviderImpl: CoroutineContextProvider {
    override fun io(): CoroutineContext = Dispatchers.IO
    override fun computation(): CoroutineContext = Dispatchers.Default
    override fun ui(): CoroutineContext = Dispatchers.Main
}