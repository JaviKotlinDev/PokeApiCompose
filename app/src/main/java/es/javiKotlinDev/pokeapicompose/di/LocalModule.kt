package es.javiKotlinDev.pokeapicompose.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.javiKotlinDev.pokeapicompose.constans.PokeApiConstants
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(PokeApiConstants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

}