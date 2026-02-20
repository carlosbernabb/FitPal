package com.fitpal.app

/**
 * Data class representing a single recipe card on the Home screen.
 */
data class Recipe(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val rating: Float,
    val timeMinutes: Int,
    val calories: Int
)
