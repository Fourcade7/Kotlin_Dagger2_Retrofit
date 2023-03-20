package com.pr7.kotlin_dagger2_retrofit.di

import com.pr7.kotlin_dagger2_retrofit.MainActivity


@dagger.Component(modules = [ApiModule::class])
interface Component {

    fun inject(mainActivity: MainActivity)
}