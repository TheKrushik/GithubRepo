package com.example.githubrepo.repository


import com.example.githubrepo.models.Repo
import com.example.githubrepo.remote.GithubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository
@Inject internal constructor(private val api: GithubService) {

    suspend fun loadRepoList(user: String): List<Repo> {
        var list: List<Repo> = listOf()
        withContext(Dispatchers.IO) {
            list = api.loadReposAsync(user = user)
        }
        return list
    }
}