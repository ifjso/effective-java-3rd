package com.js.effectivejava.item34;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlanetTest {

    @ParameterizedTest
    @EnumSource(Planet.class)
    @DisplayName("각 행성에서 주어진 질량의 표면 중량을 계산한다.")
    void testSurfaceWeight(Planet planet) {
        double actual = planet.surfaceWeight(10);
        assertThat(actual).isEqualTo(planet.getSurfaceGravity() * 10);
    }
}