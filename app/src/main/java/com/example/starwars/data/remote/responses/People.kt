package com.example.starwars.data.remote.responses

data class People(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)