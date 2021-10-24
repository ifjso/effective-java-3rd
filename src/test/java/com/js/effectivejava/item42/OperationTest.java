package com.js.effectivejava.item42;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @ParameterizedTest
    @MethodSource("provideOpsAndOperandsAndExpected")
    @DisplayName("각 연산을 검증한다.")
    void apply(Operation op, double x, double y, double expected) {
        double actual = op.apply(x, y);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideOpsAndOperandsAndExpected() {
        return Stream.of(
                Arguments.of(Operation.PLUS, 10, 5, 15),
                Arguments.of(Operation.MINUS, 10, 5, 5),
                Arguments.of(Operation.TIMES, 10, 5, 50),
                Arguments.of(Operation.DIVIDE, 10, 5, 2));
    }
}
