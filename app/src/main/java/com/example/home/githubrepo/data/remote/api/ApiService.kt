package com.example.home.githubrepo.data.remote.api

import com.example.home.githubrepo.data.remote.model.Repository
import com.example.home.githubrepo.data.remote.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Home on 2018-12-03.
 */
interface ApiService {

    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Single<User>

    @GET("users/{user}/repos")
    fun getUserRepo(@Path("user") user: String): Single<List<Repository>>
}
