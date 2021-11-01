package com.js.effectivejava.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Pi {

    private Pi() {
        throw new AssertionError();
    }

    public static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static long piByParallel(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
