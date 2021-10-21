package com.js.effectivejava.item38;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @ParameterizedTest
    @MethodSource("provideOperationsAndOperandsAndExpected")
    @DisplayName("Basic, Extended 연산을 검증한다.")
    void a(Operation op, double x, double y, double expected) {
        double actual = op.apply(x, y);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideOperationsAndOperandsAndExpected() {
        return Stream.of(
                Arguments.of(BasicOperation.PLUS, 10, 5, 15),
                Arguments.of(BasicOperation.MINUS, 10, 5, 5),
                Arguments.of(BasicOperation.TIMES, 10, 5, 50),
                Arguments.of(BasicOperation.DIVIDE, 10, 5, 2),
                Arguments.of(ExtendedOperation.EXP, 10, 5, 100000),
                Arguments.of(ExtendedOperation.REMAINDER, 10, 5, 0));
    }
}
