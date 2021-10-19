package com.js.effectivejava.item34;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static com.js.effectivejava.item34.Operation.DIVIDE;
import static com.js.effectivejava.item34.Operation.MINUS;
import static com.js.effectivejava.item34.Operation.PLUS;
import static com.js.effectivejava.item34.Operation.TIMES;
import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @ParameterizedTest
    @EnumSource(Operation.class)
    @DisplayName("문자열에 해당하는 열거형 상수를 반환한다.")
    void whenFromString_thenReturnOperation(Operation operation) {
        Optional<Operation> actual = Operation.fromString(operation.toString());

        assertThat(actual).isPresent();
        assertThat(actual.get()).isEqualTo(operation);
    }

    @Test
    @DisplayName("문자열에 해당하는 열거형 상수가 없으면 empty를 반환한다.")
    void whenFromString_thenReturnEmpty() {
        Optional<Operation> actual = Operation.fromString("-1");
        assertThat(actual).isNotPresent();
    }

    @ParameterizedTest
    @MethodSource("provideOperationsAndParameters")
    @DisplayName("사칙연산을 검증한다.")
    void whenApply_thenSucceed(Operation operation, double x, double y, double expected) {
        double actual = operation.apply(x, y);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideOperationsAndParameters() {
        return Stream.of(
                Arguments.of(PLUS, 3, 2, 5),
                Arguments.of(MINUS, 3, 2, 1),
                Arguments.of(TIMES, 3, 2, 6),
                Arguments.of(DIVIDE, 3, 2, 1.5));
    }
}