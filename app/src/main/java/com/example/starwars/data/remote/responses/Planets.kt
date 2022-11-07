package com.example.starwars.data.remote.responses

data class Planets(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResultX>
)