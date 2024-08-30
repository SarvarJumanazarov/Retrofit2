package uz.example.retrofit2.lesson5

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.example.retrofit2.lesson1.ApiClent

object ApiClent {
    const val BASE_URL="https://hp-api.onrender.com/"

    fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(ApiClent.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}