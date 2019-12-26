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

    private val _repos = MutableLiveData<List<Repo>>()

    val repos: LiveData<List<Repo>>
        get() = _repos

    init {
        _repos.value = ArrayList()
    }

//    fun getRepoList(user: String) {
////        repoLiveData.value?.add(issuePost)
//        _repos.value = repositoryList(user)
//    }


    fun repositoryList(user: String) {
        viewModelScope.launch {
            repository.loadRepoList(user)
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
