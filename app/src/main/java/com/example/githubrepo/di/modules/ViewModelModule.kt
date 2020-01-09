package com.example.githubrepo.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubrepo.di.ViewModelKey
import com.example.githubrepo.ui.repos.ReposViewModel
import com.example.githubrepo.ui.user.UserViewModel
import com.example.githubrepo.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    internal abstract fun bindUserViewModel(viewModel: UserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    internal abstract fun bindReposViewModel(viewModel: ReposViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
