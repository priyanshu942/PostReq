package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface userPost {

    //https://cloud.cypherx.in/  register

    @POST("register")
    fun sendUser(
        @Body DataType: dataType
    ): Call<dataType>
}