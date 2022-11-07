package com.example.starwars.data.remote.responses

data class Films(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<ResultXX>
)