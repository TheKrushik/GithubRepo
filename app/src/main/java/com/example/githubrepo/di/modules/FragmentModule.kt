package com.example.githubrepo.di.modules

import com.example.githubrepo.ui.repos.ReposFragment
import com.example.githubrepo.ui.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeUserFragment(): UserFragment

    @ContributesAndroidInjector
    internal abstract fun contributeReposFragment(): ReposFragment


}
