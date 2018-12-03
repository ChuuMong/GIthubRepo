package com.example.home.githubrepo.presenter


/**
 * Created by Home on 2018-12-03.
 */
interface View {

    fun showErrorMessage(throwable: Throwable)

    fun showProgress()

    fun hideProgress()
}
