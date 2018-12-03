package com.example.home.githubrepo.data.remote.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Home on 2018-12-03.
 */

data class Repository(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("stargazers_count")
    val starCount: Int
)