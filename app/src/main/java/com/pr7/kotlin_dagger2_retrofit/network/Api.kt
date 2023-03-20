package com.pr7.kotlin_dagger2_retrofit.network


import com.pr7.kotlin_dagger2_retrofit.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface Api {


    @GET("posts")
    fun getAllPosts(): Call<ArrayList<Post>>

}