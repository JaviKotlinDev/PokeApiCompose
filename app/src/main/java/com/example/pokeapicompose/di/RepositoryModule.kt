package com.example.pokeapicompose.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

//    @Provides
//    @Singleton
//    fun provideExampleRepository(exampleLocalDataSource: ExampleLocalDataSource): ExampleRepository =
//        ExampleRepositoryImpl(exampleLocalDataSource)

}