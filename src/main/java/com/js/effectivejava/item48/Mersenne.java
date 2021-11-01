package com.js.effectivejava.item48;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Mersenne {

    private Mersenne() {
        throw new AssertionError();
    }

    public static void mersenne() {
        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    private static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }
}
