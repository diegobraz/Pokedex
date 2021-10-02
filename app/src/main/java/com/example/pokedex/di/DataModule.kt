package com.example.pokedex.di

import com.example.pokedex.data.PokemonDataSouce
import com.example.pokedex.repository.PokemonServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun providePokemnoDataSource(dataSouce: PokemonServiceImpl):PokemonDataSouce

}