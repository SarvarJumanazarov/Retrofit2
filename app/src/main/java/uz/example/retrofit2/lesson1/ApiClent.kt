package uz.example.retrofit2.lesson1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClent {
    const val BASE_URL="https://raw.githubusercontent.com"

   fun getRetrofit(): Retrofit {

       return Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
   }
}