package uz.example.retrofit2

import android.telecom.Call
import retrofit2.http.GET

interface ApiServise {
    @GET(value ="demos/marvel/")
    fun getSuperHeros(): retrofit2.Call<List<SuperHerosItem>>
}