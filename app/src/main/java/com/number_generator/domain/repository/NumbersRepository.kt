package com.number_generator.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import java.math.BigInteger

interface NumbersRepository {

    fun getFibNumbers(): Flow<PagingData<BigInteger>>

    fun getPrimeNumbers(): Flow<PagingData<BigInteger>>
}
