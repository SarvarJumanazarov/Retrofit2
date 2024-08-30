package uz.example.retrofit2.lesson3

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.example.retrofit2.lesson2.ApiClent

object ApiClent {

    const val BASE_URL="https://raw.githubusercontent.com"

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
            .baseUrl(ApiClent.BASE_URL)
            .client(client)  // Set the OkHttpClient
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}