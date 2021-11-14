package com.js.effectivejava.item53;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MathTest {

    @Test
    @DisplayName("입력된 값 중 최솟값을 반환한다.")
    void min() {
        // given
        // when
        int actual = Math.min(6, 3, 2, 1, -9, -8, 4);

        // then
        assertThat(actual).isEqualTo(-9);
    }
}