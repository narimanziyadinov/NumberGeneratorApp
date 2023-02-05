package com.number_generator.data.data_source

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import java.math.BigInteger

interface NumbersLocalDataSource {
    fun getFibNumbers(): Flow<PagingData<BigInteger>>
    fun getPrimeNumbers(): Flow<PagingData<BigInteger>>
}
