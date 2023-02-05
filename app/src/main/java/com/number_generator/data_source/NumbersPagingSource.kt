package com.number_generator.data_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.core.Generator
import java.math.BigInteger

internal const val LOADING_SIZE = 10

class NumbersPagingSource(private val generator: Generator) : PagingSource<Int, BigInteger>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BigInteger> {
        val pageIndex = params.key
        val limit = pageIndex ?: LOADING_SIZE

        val result = generator.range(limit, limit - LOADING_SIZE)

        val nextKey = if (result.isEmpty()) {
            null
        } else {
            limit + LOADING_SIZE
        }

        return LoadResult.Page(
            data = result,
            prevKey = null,
            nextKey = nextKey
        )
    }

    override fun getRefreshKey(state: PagingState<Int, BigInteger>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
