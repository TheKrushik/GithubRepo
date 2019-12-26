package com.example.githubrepo.remote

import com.example.githubrepo.models.Repo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}/repos")
    fun loadReposAsync(@Path("user") user: String): Deferred<List<Repo>>
}