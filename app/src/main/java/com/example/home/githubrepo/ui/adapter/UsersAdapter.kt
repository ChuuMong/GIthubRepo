package com.example.home.githubrepo.ui.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.home.githubrepo.R
import com.example.home.githubrepo.data.remote.model.Repository
import com.example.home.githubrepo.data.remote.model.User


/**
 * Created by Home on 2018-12-03.
 */
class UsersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1

        private const val HEADER_POSITION = 0
    }

    private val users = mutableListOf<User>()
    private val repositories = mutableListOf<Repository>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_user_item, parent, false)
                HeaderViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_repo_item, parent, false)
                RepoViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HeaderViewHolder) {
            holder.bind(users[HEADER_POSITION])
        } else if (holder is RepoViewHolder) {
            holder.bind(repositories[getItemPosition(position)])
        }
    }

    private fun getItemPosition(position: Int): Int {
        return position - 1
    }

    override fun getItemCount(): Int {
        return users.size + repositories.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            HEADER_POSITION -> TYPE_HEADER
            else -> TYPE_ITEM
        }
    }

    fun addUser(user: User) {
        users.clear()
        users.add(user)

        notifyDataSetChanged()
    }

    fun addAllRepository(repositories: List<Repository>) {
        this.repositories.clear()
        this.repositories.addAll(repositories)

        notifyDataSetChanged()
    }

    inner class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ivUser: ImageView = view.findViewById(R.id.ivUser)
        private val tvUserName: TextView = view.findViewById(R.id.tvUserName)

        fun bind(user: User) {
            tvUserName.text = user.login
            Glide.with(itemView.context).load(user.imageUrl).into(ivUser)
        }
    }

    inner class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvRepoName: TextView = view.findViewById(R.id.tvRepoName)
        private val tvRepoDescription: TextView = view.findViewById(R.id.tvRepoDescription)
        private val tvStarCount: TextView = view.findViewById(R.id.tvStarCount)

        fun bind(repository: Repository) {
            tvRepoName.text = repository.name
            tvRepoDescription.text = repository.description
            tvStarCount.text = repository.starCount.toString()
        }
    }
}