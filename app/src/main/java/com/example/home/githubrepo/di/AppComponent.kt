package com.example.home.githubrepo.di

import android.app.Application
import com.example.home.githubrepo.App
import com.example.home.githubrepo.di.activity.ActivityBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by Home on 2018-12-03.
 */

@Singleton
@Component(modules = [AppModule::class, ApiModule::class, ActivityBindingModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}