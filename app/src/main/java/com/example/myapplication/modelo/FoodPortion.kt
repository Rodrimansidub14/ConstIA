package com.example.myapplication.modelo

data class FoodPortion(
    val amount: Double,
    val gramWeight: Double,
    val id: Int,
    val measureUnit: MeasureUnit,
    val minYearAcquired: Int,
    val modifier: String,
    val portionDescription: String,
    val sequenceNumber: Int,
    val value: Double
)