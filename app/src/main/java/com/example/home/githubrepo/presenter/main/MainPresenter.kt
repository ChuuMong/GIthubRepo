package com.example.home.githubrepo.presenter.main

import com.example.home.githubrepo.data.remote.model.Repository
import com.example.home.githubrepo.data.repository.UserRepository
import com.example.home.githubrepo.presenter.Presenter
import javax.inject.Inject


/**
 * Created by Home on 2018-12-03.
 */
class MainPresenter @Inject
constructor(private val userRepository: UserRepository) : Presenter<MainView>() {

    fun getUser(user: String) {
        disposable.add(userRepository.getUser(user).doFinally {
            view?.hideProgress()
        }.subscribe({
            view?.resultUser(it)
            getUserRepo(user)
        }, {
            view?.showErrorMessage(it)
        }))
    }

    private fun getUserRepo(user: String) {
        disposable.add(userRepository.getUserRepo(user).map {
            it.sortedWith(compareBy(Repository::starCount)).reversed()
        }.doFinally {
            view?.hideProgress()
        }.subscribe({
            view?.resultUserRepos(it)
        }, {
            view?.showErrorMessage(it)
        }))
    }
}