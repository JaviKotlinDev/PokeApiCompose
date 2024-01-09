package es.javiKotlinDev.pokeapicompose.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

//    @Provides
//    fun provideExampleUseCase(repository: ExampleRepository): ExampleUseCase =
//        ExampleUseCaseImpl(repository)

}