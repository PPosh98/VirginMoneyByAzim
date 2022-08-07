package com.example.virginmoneyappazim.di

import com.example.virginmoneyappazim.repository.Repository
import com.example.virginmoneyappazim.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun getRepository(repository: RepositoryImpl): Repository
}