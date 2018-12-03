package com.example.home.githubrepo.data.repository

import com.example.home.githubrepo.data.remote.api.ApiService
import com.example.home.githubrepo.data.remote.model.Repository
import com.example.home.githubrepo.data.remote.model.User
import io.reactivex.Single
import javax.inject.Inject


/**
 * Created by Home on 2018-12-03.
 */

class UserRepository @Inject constructor(apiService: ApiService) : BaseRepository(apiService) {

    fun getUser(user: String): Single<User> {
        return apiService.getUser(user)
    }

    fun getUserRepo(user: String): Single<List<Repository>> {
        return apiService.getUserRepo(user)
    }
}