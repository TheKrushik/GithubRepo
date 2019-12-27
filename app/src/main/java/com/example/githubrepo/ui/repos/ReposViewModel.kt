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

    private val _status = MutableLiveData<RequestStatus>()
    val status: LiveData<RequestStatus>
        get() = _status


    private val _pepos = MutableLiveData<List<Repo>>()
    val repos: LiveData<List<Repo>>
        get() = _pepos


    fun getRepoList(user: String) {
        viewModelScope.launch {
            try {
                _status.value = RequestStatus.LOADING
                val listResult = repository.loadRepoList(user)
                Log.d("MyTag", "repositoryList: $listResult")
                _status.value = RequestStatus.DONE
                _pepos.value = listResult
            } catch (e: Exception) {
                _status.value = RequestStatus.ERROR
                _pepos.value = ArrayList()
            }

        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

enum class RequestStatus { LOADING, ERROR, DONE }