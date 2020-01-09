package com.example.githubrepo.ui.user


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject


class UserViewModel @Inject constructor() : ViewModel() {

    val _userName = MutableLiveData<String>()
    val userName: LiveData<String>
        get() = _userName

}
