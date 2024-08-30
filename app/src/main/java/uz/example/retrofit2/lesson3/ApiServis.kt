package uz.example.retrofit2.lesson3

import retrofit2.Call
import retrofit2.http.GET
import uz.example.retrofit2.lesson2.Currency

interface ApiServis {
    @GET(value ="/oz/arkhiv-kursov-valyut/json")
    fun getAllCurrency(): Call<List<Currency>>
}