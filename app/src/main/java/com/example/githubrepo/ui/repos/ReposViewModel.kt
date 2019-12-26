package com.example.githubrepo.ui.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepo.models.Repo
import com.example.githubrepo.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReposViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var user: String = ""

    private val _repos = MutableLiveData<List<Repo>>()

    val repos: LiveData<List<Repo>>
        get() = _repos

    init {
//        _repos.value = repositoryList(user)
    }

    fun repositoryList(user: String): List<Repo> {
        var repoList = listOf<Repo>()
        viewModelScope.launch {
            repoList = repository.loadRepoList(user)
        }
        return repoList
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}