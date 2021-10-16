package com.js.effectivejava.item30;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenericSingletonFactoryPatternTest {

    @Test
    @DisplayName("항등원 함수의 입력과 출력값은 같은 참조여야 한다.")
    void test_identityFunction() {
        String a = "a";

        String actual = GenericSingletonFactoryPattern.<String>identityFunction().apply(a);

        assertThat(a).isSameAs(actual);
    }
}