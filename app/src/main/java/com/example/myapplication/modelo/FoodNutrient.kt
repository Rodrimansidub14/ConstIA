package com.example.myapplication.modelo

data class FoodNutrient(
    val amount: Double,
    val dataPoints: Int,
    val foodNutrientDerivation: FoodNutrientDerivation,
    val footnote: String,
    val id: Int,
    val max: Double,
    val median: Double,
    val min: Double,
    val nutrient: Nutrient,
    val type: String
)