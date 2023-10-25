package com.example.myapplication.modelo

data class NutrientConversionFactor(
    val carbohydrateValue: Double,
    val fatValue: Double,
    val nitrogenValue: Double,
    val proteinValue: Double,
    val type: String,
    val value: Double
)