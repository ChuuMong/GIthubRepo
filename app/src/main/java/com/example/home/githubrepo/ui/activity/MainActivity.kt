package com.example.home.githubrepo.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.home.githubrepo.R
import com.example.home.githubrepo.data.remote.model.Repository
import com.example.home.githubrepo.data.remote.model.User
import com.example.home.githubrepo.presenter.main.MainPresenter
import com.example.home.githubrepo.presenter.main.MainView
import com.example.home.githubrepo.ui.adapter.UsersAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var adapter: UsersAdapter

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = intent?.data?.lastPathSegment ?: return

        Log.d(TAG, "user : $user")

        listUsers.layoutManager = LinearLayoutManager(this)
        adapter = UsersAdapter()
        listUsers.adapter = adapter

        presenter.attachView(this)
        presenter.getUser(user)
    }

    override fun resultUser(user: User) {
        adapter.addUser(user)
    }

    override fun resultUserRepos(repos: List<Repository>) {
        adapter.addAllRepository(repos)
    }

    override fun showErrorMessage(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }
}
