package com.example.home.githubrepo.di.activity

import javax.inject.Scope


/**
 * Created by Home on 2018-12-03.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ActivityScoped
