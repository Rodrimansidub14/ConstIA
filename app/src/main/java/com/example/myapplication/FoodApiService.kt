package com.example.myapplication

import com.example.myapplication.modelo.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApiService {
    @GET("api/v2/search") // Endpoint actualizado
    suspend fun searchFoods(
        @Query("search_terms") query: String, // Término de búsqueda
        @Query("json") json: Boolean = true, // Asegurarse de que la respuesta sea en formato JSON
        @Query("fields") fields: String = "product_name,nutriments,nutriscore_data,nutrition_grades" // Campos específicos
    ): ApiResponse
}
