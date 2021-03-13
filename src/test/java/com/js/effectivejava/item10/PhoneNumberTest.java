package com.js.effectivejava.item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneNumberTest {

    private static final PhoneNumber BASE_PHONE_NUMBER = createPhoneNumber(100, 100, 100);

    private static Stream<Arguments> providePhoneNumbersAndExpected() {
        return Stream.of(
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithAreaCode(100), true),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithPrefix(100), true),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithLineNum(100), true),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithAreaCode(200), false),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithPrefix(200), false),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithLineNum(200), false)
        );
    }

    private static PhoneNumber createPhoneNumberWithAreaCode(int areaCode) {
        return createPhoneNumber(areaCode, 100, 100);
    }

    private static PhoneNumber createPhoneNumberWithPrefix(int prefix) {
        return createPhoneNumber(100, prefix, 100);
    }

    private static PhoneNumber createPhoneNumberWithLineNum(int lineNum) {
        return createPhoneNumber(100, 100, lineNum);
    }

    private static PhoneNumber createPhoneNumber(int areaCode, int prefix, int lineNum) {
        return new PhoneNumber(areaCode, prefix, lineNum);
    }

    @ParameterizedTest
    @MethodSource("providePhoneNumbersAndExpected")
    @DisplayName("모든 필드 값이 서로 같아야 동치이다.")
    void test_equals(PhoneNumber pnOne, PhoneNumber pnTwo, boolean expected) {
        boolean actualOne = pnOne.equals(pnTwo);
        boolean actualTwo = pnTwo.equals(pnOne);

        assertThat(actualOne).isEqualTo(expected);
        assertThat(actualTwo).isEqualTo(expected);
    }
}
