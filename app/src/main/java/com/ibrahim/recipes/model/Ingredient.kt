package com.ibrahim.recipes.model

data class Ingredient(
    val id: Long?,
    val recipeId: Long,
    val name: String,
    val quantity: String
)
