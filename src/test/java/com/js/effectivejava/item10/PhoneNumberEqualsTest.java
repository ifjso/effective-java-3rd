package com.js.effectivejava.item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PhoneNumber equals, hashCode 검증")
public class PhoneNumberEqualsTest {

    private static final PhoneNumber BASE_PHONE_NUMBER = createPhoneNumber(100, 100, 1000);

    private static Stream<Arguments> providePhoneNumbersAndExpectedForEquals() {
        return Stream.of(
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithAreaCode(100), true),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithPrefix(100), true),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithLineNum(1000), true),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithAreaCode(200), false),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithPrefix(200), false),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithLineNum(2000), false)
        );
    }

    private static Stream<Arguments> providePhoneNumbersAndExpectedForHashCode() {
        return Stream.of(
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithAreaCode(100), true),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithPrefix(100), true),
                Arguments.of(BASE_PHONE_NUMBER, createPhoneNumberWithLineNum(1000), true)
        );
    }

    public static PhoneNumber createPhoneNumberWithAreaCode(int areaCode) {
        return createPhoneNumber(areaCode, 100, 1000);
    }

    public static PhoneNumber createPhoneNumberWithPrefix(int prefix) {
        return createPhoneNumber(100, prefix, 1000);
    }

    public static PhoneNumber createPhoneNumberWithLineNum(int lineNum) {
        return createPhoneNumber(100, 100, lineNum);
    }

    public static PhoneNumber createPhoneNumber(int areaCode, int prefix, int lineNum) {
        return new PhoneNumber(areaCode, prefix, lineNum);
    }

    @ParameterizedTest
    @MethodSource("providePhoneNumbersAndExpectedForEquals")
    @DisplayName("모든 필드 값이 서로 같아야 동치이다.")
    void test_equals(PhoneNumber pnOne, PhoneNumber pnTwo, boolean expected) {
        boolean actualOne = pnOne.equals(pnTwo);
        boolean actualTwo = pnTwo.equals(pnOne);

        assertThat(actualOne).isEqualTo(expected);
        assertThat(actualTwo).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("providePhoneNumbersAndExpectedForHashCode")
    @DisplayName("모든 필드 값이 서로 같다면 해시코드도 같다.")
    void test(PhoneNumber pnOne, PhoneNumber pnTwo, boolean expected) {
        boolean actual = pnOne.hashCode() == pnTwo.hashCode();

        assertThat(actual).isEqualTo(expected);
    }
}
