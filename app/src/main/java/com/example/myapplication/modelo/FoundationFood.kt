package com.example.myapplication.modelo

data class FoundationFood(
    val dataType: String,
    val description: String,
    val fdcId: Int,
    val foodAttributes: List<Any>,
    val foodCategory: FoodCategory,
    val foodClass: String,
    val foodNutrients: List<FoodNutrient>,
    val foodPortions: List<FoodPortion>,
    val inputFoods: List<InputFood>,
    val isHistoricalReference: Boolean,
    val ndbNumber: Int,
    val nutrientConversionFactors: List<NutrientConversionFactor>,
    val publicationDate: String,
    val scientificName: String
)