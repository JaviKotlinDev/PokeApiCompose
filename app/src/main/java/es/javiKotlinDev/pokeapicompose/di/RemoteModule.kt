package es.javiKotlinDev.pokeapicompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.javiKotlinDev.pokeapicompose.data.dataSource.PokeApiDataSource
import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.PokeApiDataSourceImpl
import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.PokeApiService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteModule {

    @Provides
    @Singleton
    fun providePokeApiRemoteDataSource(service: PokeApiService): PokeApiDataSource =
        PokeApiDataSourceImpl(service)

}