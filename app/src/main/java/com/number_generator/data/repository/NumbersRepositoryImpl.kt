package com.number_generator.data.repository

import androidx.paging.PagingData
import com.number_generator.data.data_source.NumbersLocalDataSource
import com.number_generator.domain.repository.NumbersRepository
import kotlinx.coroutines.flow.Flow
import java.math.BigInteger
import javax.inject.Inject

class NumbersRepositoryImpl @Inject constructor(
    private val numbersLocalDataSource: NumbersLocalDataSource
) : NumbersRepository {

    override fun getFibNumbers(): Flow<PagingData<BigInteger>> {
        return numbersLocalDataSource.getFibNumbers()
    }

    override fun getPrimeNumbers(): Flow<PagingData<BigInteger>> {
        return numbersLocalDataSource.getPrimeNumbers()
    }
}
