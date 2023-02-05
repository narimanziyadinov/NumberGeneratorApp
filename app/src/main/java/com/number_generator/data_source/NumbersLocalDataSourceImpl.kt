package com.number_generator.data_source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.number_generator.data.data_source.NumbersLocalDataSource
import com.number_generator.fib_generator.FibonacciGenerator
import com.number_generator.prime_numbers_generator.PrimeNumbersGenerator
import kotlinx.coroutines.flow.Flow
import java.math.BigInteger
import javax.inject.Inject

internal const val LOADING_PAGE_SIZE = 1

class NumbersLocalDataSourceImpl @Inject constructor(
    private val primeNumbersGenerator: PrimeNumbersGenerator,
    private val fibonacciGenerator: FibonacciGenerator,
) : NumbersLocalDataSource {

    override fun getFibNumbers(): Flow<PagingData<BigInteger>> {
        return Pager(
            config = PagingConfig(
                pageSize = LOADING_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                NumbersPagingSource(fibonacciGenerator)
            }
        ).flow
    }

    override fun getPrimeNumbers(): Flow<PagingData<BigInteger>> {
        return Pager(
            config = PagingConfig(
                pageSize = LOADING_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                NumbersPagingSource(primeNumbersGenerator)
            }
        ).flow
    }
}
