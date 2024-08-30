package uz.example.retrofit2.lesson4

import retrofit2.Call
import retrofit2.http.GET
import uz.example.retrofit2.lesson2.Currency

interface ApiServis {
    @GET(value ="/search.json?q=the+lord+of+the+rings")
    fun getAllCurrency(): Call<List<Kino>>
}