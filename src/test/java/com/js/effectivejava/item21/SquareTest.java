package com.js.effectivejava.item21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SquareTest {

    @Test
    void test_area() {
        // given
        Figure square = new Square(1.2);

        // when
        double actual = square.area();

        // then
        assertThat(actual).isEqualTo(1.44);
    }
}