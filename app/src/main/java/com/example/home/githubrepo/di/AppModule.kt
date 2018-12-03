package com.example.home.githubrepo.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module


/**
 * Created by Home on 2018-12-03.
 */

@Module
abstract class AppModule {

    @Binds
    internal abstract fun bindContext(application: Application): Context
}