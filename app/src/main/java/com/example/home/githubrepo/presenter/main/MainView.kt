package com.example.home.githubrepo.presenter.main

import com.example.home.githubrepo.data.remote.model.Repository
import com.example.home.githubrepo.data.remote.model.User
import com.example.home.githubrepo.presenter.View


/**
 * Created by Home on 2018-12-03.
 */
interface MainView : View {

    fun resultUser(user: User)

    fun resultUserRepos(repos: List<Repository>)

}