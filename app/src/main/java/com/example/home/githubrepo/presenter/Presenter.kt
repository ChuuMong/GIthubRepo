package com.example.home.githubrepo.presenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Home on 2018-12-03.
 */
abstract class Presenter<V : View> {

    protected val disposable: CompositeDisposable = CompositeDisposable()

    protected var view: V? = null

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        disposable.dispose()

        view = null
    }

}
