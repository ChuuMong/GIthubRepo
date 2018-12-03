package com.example.home.githubrepo.di.activity

import com.example.home.githubrepo.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Home on 2018-12-03.
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity
}