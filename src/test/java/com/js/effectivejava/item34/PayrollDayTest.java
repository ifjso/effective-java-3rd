package com.js.effectivejava.item34;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.js.effectivejava.item34.PayrollDay.FRIDAY;
import static com.js.effectivejava.item34.PayrollDay.MONDAY;
import static com.js.effectivejava.item34.PayrollDay.SATURDAY;
import static com.js.effectivejava.item34.PayrollDay.SUNDAY;
import static com.js.effectivejava.item34.PayrollDay.THURSDAY;
import static com.js.effectivejava.item34.PayrollDay.TUESDAY;
import static com.js.effectivejava.item34.PayrollDay.WEDNESDAY;
import static org.assertj.core.api.Assertions.assertThat;

class PayrollDayTest {

    @ParameterizedTest
    @MethodSource("provideDaysAndExpected")
    @DisplayName("임금 계산을 검증한다.")
    void whenPay_thenSucceed(PayrollDay day, int expected) {
        int actual = day.pay(60 * 9, 1);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideDaysAndExpected() {
        return Stream.of(
                Arguments.of(MONDAY, 570),
                Arguments.of(TUESDAY, 570),
                Arguments.of(WEDNESDAY, 570),
                Arguments.of(THURSDAY, 570),
                Arguments.of(FRIDAY, 570),
                Arguments.of(SATURDAY, 810),
                Arguments.of(SUNDAY, 810));
    }
}