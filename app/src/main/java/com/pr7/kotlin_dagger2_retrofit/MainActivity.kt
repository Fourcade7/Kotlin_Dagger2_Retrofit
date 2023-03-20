package com.pr7.kotlin_dagger2_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pr7.kotlin_dagger2_retrofit.di.Injector.component
import com.pr7.kotlin_dagger2_retrofit.model.Post
import com.pr7.kotlin_dagger2_retrofit.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var api:Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)

        val call:Call<ArrayList<Post>> = api.getAllPosts()
        call.enqueue(object :Callback<ArrayList<Post>>{
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                if (response.isSuccessful){
                    Log.d("PR77777", "onResponse code=: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }
        })
    }
}