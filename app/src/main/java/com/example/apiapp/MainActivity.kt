package com.example.apiapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import coil.load



class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val image=findViewById<ImageView>(R.id.imageView2)
        val sg=SG.buildService(ApiInterface::class.java)

        val call=sg.getMeows()

        call.enqueue(object :Callback<Mewo>{
            override fun onResponse(call: Call<Mewo>, response: Response<Mewo>) {
                if(response.isSuccessful){
                    Log.i("RADIA",response.body()!!.url)
                    image.load("")
                    }

            }

            override fun onFailure(call: Call<Mewo>, t: Throwable) {

                Log.i("NERADI","NE")

            }


        })



    }
}