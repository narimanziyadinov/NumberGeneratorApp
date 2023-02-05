package com.number_generator.data.di

import com.number_generator.data.data_source.NumbersLocalDataSource
import com.number_generator.data.repository.NumbersRepositoryImpl
import com.number_generator.data_source.NumbersLocalDataSourceImpl
import com.number_generator.domain.repository.NumbersRepository
import com.number_generator.fib_generator.FibonacciGenerator
import com.number_generator.prime_numbers_generator.PrimeNumbersGenerator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindNumbersDataSource(impl: NumbersLocalDataSourceImpl): NumbersLocalDataSource

    @Binds
    fun bindNumbersRepository(impl: NumbersRepositoryImpl): NumbersRepository

}

@Module
@InstallIn(SingletonComponent::class)
object NumbersModule {
    @Provides
    fun provideFibGenerator(): FibonacciGenerator {
        return FibonacciGenerator()
    }

    @Provides
    fun providePrimeNumbersGenerator(): PrimeNumbersGenerator {
        return PrimeNumbersGenerator()
    }
}
