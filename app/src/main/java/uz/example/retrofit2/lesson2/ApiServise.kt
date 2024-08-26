package uz.example.retrofit2.lesson2

import retrofit2.Call
import retrofit2.http.GET
import uz.example.retrofit2.lesson1.SuperHerosItem

interface ApiServise {
    @GET(value ="/oz/arkhiv-kursov-valyut/json")
    fun getAllCurrency(): Call<List<Currency>>
}