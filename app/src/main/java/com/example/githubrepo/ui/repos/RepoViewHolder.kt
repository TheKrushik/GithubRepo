package com.example.githubrepo.ui.repos

import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo.databinding.ItemRepoBinding
import com.example.githubrepo.models.Repo

class RepoViewHolder(private var binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repo: Repo){
        binding.repo = repo
        binding.executePendingBindings()
    }
}