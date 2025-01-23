package ghazimoradi.soheil.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ghazimoradi.soheil.core.database.dao.DictionaryDao
import ghazimoradi.soheil.core.database.database.DictionaryDataBase
import ghazimoradi.soheil.core.database.database.DictionaryDataBase.Companion.DATABASE_NAME

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DictionaryDataBase {
        return Room.databaseBuilder(
            context = context,
            DictionaryDataBase::class.java,
            DATABASE_NAME
        ).createFromAsset("dictionary.db").build()
    }

    @Provides
    fun provideDictionaryDao(dictionaryDataBase: DictionaryDataBase): DictionaryDao {
        return dictionaryDataBase.getDictionaryDao()
    }
}