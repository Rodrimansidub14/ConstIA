package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("format=full&nutrients=203")
    suspend fun alimentos(){
        //@Query("api_key") apiKey: String,
        //@Query("region") region: String

    }

}
object RetrofitServiceFactory{
    fun makeRetrofitService(): RetrofitService{
        return Retrofit.Builder()
            .baseUrl("https://api.nal.usda.gov/fdc/v1/food/fdcld?")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)

    }
}