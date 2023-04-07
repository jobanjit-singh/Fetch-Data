package com.example.fetchdata

import retrofit2.Call
import retrofit2.http.GET

interface retroInterface {
    @GET("/api/userlist.php")
    fun getData(): Call<ArrayList<Datamodel>>

}