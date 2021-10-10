package com.js.effectivejava.item21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RectangleTest {

    @Test
    void test_area() {
        // given
        Figure rectangle = new Rectangle(1.2, 1.4);

        // when
        double actual = rectangle.area();

        // then
        assertThat(actual).isEqualTo(1.68);
    }
}