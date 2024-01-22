package es.javiKotlinDev.pokeapicompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.javiKotlinDev.pokeapicompose.data.domain.SearchPokemonUseCase
import es.javiKotlinDev.pokeapicompose.data.domain.SearchPokemonUseCaseImpl
import es.javiKotlinDev.pokeapicompose.data.repository.PokeApiRepository

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Provides
    fun provideSearchPokemonUseCase(repository: PokeApiRepository): SearchPokemonUseCase =
        SearchPokemonUseCaseImpl(repository)

}