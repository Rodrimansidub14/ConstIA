package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.modelo.FoodProduct
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class FoodViewModel : ViewModel() {
    val foodItems = MutableLiveData<List<FoodProduct>>()
    val searchQuery = MutableLiveData("")

    companion object {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://world.openfoodfacts.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService: FoodApiService = retrofit.create(FoodApiService::class.java)
    }

    fun searchFood() {
        viewModelScope.launch {
            try {
                val query = searchQuery.value ?: return@launch
                val response = apiService.searchFoods(query)
                if (response.count > 0) {
                    foodItems.postValue(response.products)
                } else {
                    Log.d("FoodViewModel", "No products found")
                }
            } catch (e: Exception) {
                Log.e("FoodViewModel", "Error: ${e.message}")
            }
        }
    }
}
