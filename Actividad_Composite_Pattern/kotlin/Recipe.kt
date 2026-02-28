package com.fitpal.app

/**
 * Represents a single recipe item in the FitPal home feed.
 */
data class Recipe(
    val id: Int,
    val name: String,
    val imageResId: Int,       // local drawable resource (no network needed)
    val rating: Float,
    val timeMinutes: Int,
    val calories: Int,
    val category: String       // "Seafood", "Beef", "Vegan"
)
