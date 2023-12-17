package es.javiKotlinDev.pokeapicompose.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RemoteModule {

//    @Provides
//    @Singleton
//    fun provideExampleRemoteDataSource(service: ExampleService): ExampleRemoteDataSource =
//        ExampleRemoteDataSourceImpl(service)

}