package com.example.githubrepo.di.modules

import dagger.Module


@Module(includes = [ViewModelModule::class, NetModule::class])
class AppModule
