package uz.example.retrofit2.lesson4

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClent {
    const val BASE_URL="https://openlibrary.org/search.json?q=the+lord+of+the+rings"

    val interceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            // Add headers or other modifications to the request here if needed
            .build()
        chain.proceed(request)
    }

    fun getRetrofit(): Retrofit {
        // Create an OkHttpClient and add the interceptor
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        // Build the Retrofit instance using the OkHttpClient
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)  // Set the OkHttpClient
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}