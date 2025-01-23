package ghazimoradi.soheil.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ghazimoradi.soheil.core.data.DictionaryRepository
import ghazimoradi.soheil.core.data.DictionaryRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindDictionaryRepositoryImplToDictionaryRepository(
        impl: DictionaryRepositoryImpl
    ): DictionaryRepository
}