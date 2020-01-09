package com.example.githubrepo.di

import android.app.Application
import com.example.githubrepo.App
import com.example.githubrepo.di.modules.FragmentModule
import com.example.githubrepo.di.modules.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        FragmentModule::class,
        NetModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}

