package com.example.myapplication.modelo

data class InputFoodX(
    val dataType: String,
    val description: String,
    val fdcId: Int,
    val foodCategory: FoodCategoryX,
    val foodClass: String,
    val publicationDate: String
)