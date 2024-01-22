package es.javiKotlinDev.pokeapicompose.di

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.javiKotlinDev.pokeapicompose.data.dataSource.PokeApiDataSource
import es.javiKotlinDev.pokeapicompose.data.error.RepositoryErrorManager
import es.javiKotlinDev.pokeapicompose.data.repository.PokeApiRepository
import es.javiKotlinDev.pokeapicompose.data.repository.PokeApiRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepositoryErrorManager(
        sharedPreferences: SharedPreferences
    ): RepositoryErrorManager =
        RepositoryErrorManager(sharedPreferences)

    @Provides
    @Singleton
    fun providePokeApiRepository(
        pokeApiDataSource: PokeApiDataSource,
        repositoryErrorManager: RepositoryErrorManager
    ): PokeApiRepository =
        PokeApiRepositoryImpl(pokeApiDataSource, repositoryErrorManager)

}