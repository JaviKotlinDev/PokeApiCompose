package es.javiKotlinDev.pokeapicompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.javiKotlinDev.pokeapicompose.constans.PokeApiConstants
import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.PokeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideUserService(): PokeApiService =
        getAdapter(PokeApiConstants.BASE_URL).create(PokeApiService::class.java)

    private fun getAdapter(baseUrl: String) =
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}