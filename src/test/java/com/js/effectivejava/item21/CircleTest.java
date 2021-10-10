package com.js.effectivejava.item21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CircleTest {

    @Test
    void test_area() {
        // given
        Figure circle = new Circle(1.2);

        // when
        double actual = circle.area();

        // then
        assertThat(actual).isEqualTo(Math.PI * 1.44);
    }
}