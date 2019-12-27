package com.example.githubrepo.ui.repos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo.databinding.ItemRepoBinding
import com.example.githubrepo.models.Repo

class RepoAdapter : ListAdapter<Repo, RepoAdapter.RepoViewHolder>(DiffCallback){

    class RepoViewHolder(private var binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: Repo){
            binding.repo = repo
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Repo>() {
        override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoAdapter.RepoViewHolder {
        return RepoViewHolder(ItemRepoBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RepoAdapter.RepoViewHolder, position: Int) {
        val repo = getItem(position)
        holder.bind(repo)
    }
}
