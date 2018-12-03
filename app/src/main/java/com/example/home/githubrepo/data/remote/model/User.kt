package com.example.home.githubrepo.data.remote.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Home on 2018-12-03.
 */
data class User(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val imageUrl: String
)