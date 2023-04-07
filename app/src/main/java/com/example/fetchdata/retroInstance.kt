package com.example.fetchdata

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retroInstance {
    val retro = Retrofit.Builder().baseUrl("https://verify.infraveo.com/").addConverterFactory(GsonConverterFactory.create()).build()
    var dataInterface =retro.create(retroInterface::class.java)
}