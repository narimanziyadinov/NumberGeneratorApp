package com.core

import java.math.BigInteger


abstract class Generator{
    abstract fun range(n: Int, from: Int): List<BigInteger>

    protected fun fillRange(n: Int, from: Int, function: (Int) -> BigInteger): List<BigInteger> {
        val list = mutableListOf<BigInteger>()
        for (i in from until n) {
            list.add(function(i))
        }
        return list
    }
}