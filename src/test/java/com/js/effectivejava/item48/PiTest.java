package com.js.effectivejava.item48;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PiTest {

    @ParameterizedTest
    @MethodSource("provideNumbersAndExpected")
    @DisplayName("pi 결과를 검증한다.")
    void testPi(long n, long expected) {
        long actual = Pi.pi(n);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideNumbersAndExpected")
    @DisplayName("병렬로 처리하는 pi 결과를 검증한다.")
    void testPiByParallel(long n, long expected) {
        long actual = Pi.piByParallel(n);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideNumbersAndExpected() {
        return Stream.of(
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(8, 4),
                Arguments.of(10, 4),
                Arguments.of(11, 5));
    }
}
