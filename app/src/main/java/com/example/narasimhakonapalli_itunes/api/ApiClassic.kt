package com.example.narasimhakonapalli_itunes.api


import com.example.narasimhakonapalli_itunes.model.ITunesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClassic {

    // https://itunes.apple.com/search?term=pop&amp;media=music&entity=song&limit=5
    // NOTICE: you need to use &amp; after the term=<query> BUT NOT for other query terms

    @GET("https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    fun getSongs(
    ): Call<ITunesResponse>

    companion object {
        private var instance: Retrofit? = null

        fun createRetrofit(): Retrofit {
            if (instance == null) {
                instance =
                    Retrofit.Builder()
                        .baseUrl("https://itunes.apple.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return instance!! // !! -> this will NOT be null here
        }
    }
}