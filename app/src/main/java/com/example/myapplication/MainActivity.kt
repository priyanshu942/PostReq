package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private val topic= mutableListOf<String>("hellop","jiiii","ygyu","gfyt","helloscdcp","jdcdcdiiii","ddwdygyu","gfddssyt")
    private val handler: Handler = Handler()
    private lateinit var userpost: userPost
    private lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         text=findViewById(R.id.txt)
        val retrofit=Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://cloud.cypherx.in/").build()

            userpost=retrofit.create(userPost::class.java)

            schRepost()





//        repeat(100)
//        {
//            Hand.postDelayed(run, 5000)
//        }
    }

    private fun schRepost()
    {
        val a =(9..99999999999999).random()
        val b =(9..99999999999999).random()
        val c =(9..99999999999999).random()
        val e=topic[(0..8).random()]
        val f=topic[(0..8).random()]
        val snd=dataType("9422195168",a,e,b,c,f)
        val callPost=userpost.sendUser(snd)

//    val run= Runnable {}
        callPost.enqueue(object : Callback<dataType> {
            override fun onResponse(call: Call<dataType>, response: Response<dataType>) {
                text.text = response.code().toString()
                Toast.makeText(this@MainActivity,"ok",Toast.LENGTH_SHORT).show()
                handler.postDelayed(postRequestRunnable, 5000)
            }

            override fun onFailure(call: Call<dataType>, t: Throwable) {
                text.text = t.message.toString()
                Toast.makeText(this@MainActivity,"ok111",Toast.LENGTH_SHORT).show()
                handler.postDelayed(postRequestRunnable, 5000)
            }
        })
    }

    private val postRequestRunnable = Runnable {
        schRepost()
    }




}