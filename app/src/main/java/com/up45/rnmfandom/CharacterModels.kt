package com.up45.rnmfandom

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val gender: String,
    val species: String,
    val image: String
)

data class ApiResponse(
    val results: List<Character>
)
