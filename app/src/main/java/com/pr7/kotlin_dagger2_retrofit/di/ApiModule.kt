package com.pr7.kotlin_dagger2_retrofit.di

import com.pr7.kotlin_dagger2_retrofit.network.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ApiModule {

    @Provides
    fun provideRetrofit():Retrofit{
        val retrofit=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return  retrofit
    }

    @Provides
    fun provideApi(retrofit: Retrofit):Api{
        val api=retrofit.create(Api::class.java)
        return api
    }
}