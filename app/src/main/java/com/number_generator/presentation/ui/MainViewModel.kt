package com.number_generator.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.number_generator.domain.repository.NumbersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import java.math.BigInteger
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NumbersRepository
) : ViewModel() {

    fun getFibNumbers(): Flow<PagingData<BigInteger>> {
        return repository.getFibNumbers().cachedIn(viewModelScope)
    }

    fun getPrimeNumbers(): Flow<PagingData<BigInteger>> {
        return repository.getPrimeNumbers().cachedIn(viewModelScope)
    }
}
