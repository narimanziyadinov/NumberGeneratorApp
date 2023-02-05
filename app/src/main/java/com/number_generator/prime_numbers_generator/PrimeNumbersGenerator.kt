package com.number_generator.prime_numbers_generator

import com.core.Generator
import java.math.BigInteger
import javax.inject.Inject
import kotlin.math.roundToInt
import kotlin.math.sqrt

class PrimeNumbersGenerator @Inject constructor(): Generator() {

    override fun range(n: Int, from: Int): List<BigInteger> {
        return fillRange(n, from) {
            nthPrime(it)
        }
    }

    private fun nthPrime(n: Int): BigInteger {
        var count = 0
        var i = 3

        while (count < n) {
            if (isPrime(i)) {
                count++
            }
            i++
        }
        return (i - 1).toBigInteger()
    }

    private fun isPrime(n: Int): Boolean {
        if (n <= 1) return false
        for (i in 2..sqrt(n.toDouble()).roundToInt()) {
            if (n % i == 0) return false
        }
        return true
    }
}
