package com.example.starwars.data.remote.responses

data class Species(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResultXXX>
)