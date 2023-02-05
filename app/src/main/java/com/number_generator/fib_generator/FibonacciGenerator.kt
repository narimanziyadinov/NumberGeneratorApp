package com.number_generator.fib_generator

import com.core.Generator
import java.math.BigInteger
import javax.inject.Inject

class FibonacciGenerator @Inject constructor(): Generator() {

    private fun fibonacci(n: Int): BigInteger {
        if (n <= 1) return n.toBigInteger()
        var prev = BigInteger.valueOf(0)
        var current = BigInteger.valueOf(1)
        var next: BigInteger
        for (i in 2..n) {
            next = prev + current
            prev = current
            current = next
        }
        return current
    }

    override fun range(n: Int, from: Int): List<BigInteger> {
        return fillRange(n, from) {
            fibonacci(it)
        }
    }
}
