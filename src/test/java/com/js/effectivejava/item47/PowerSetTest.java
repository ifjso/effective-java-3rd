package com.js.effectivejava.item47;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PowerSetTest {

    @Test
    @DisplayName("{a, b, c} 의 멱집합을 반환한다.")
    void testOf() {
        // given
        Set<String> s = Set.of("a", "b", "c");

        // when
        Collection<Set<String>> actual = PowerSet.of(s);

        // then
        assertThat(actual).hasSize(8);
        assertThat(actual).containsExactly(
            Set.of(),
            Set.of("a"),
            Set.of("b"),
            Set.of("a", "b"),
            Set.of("c"),
            Set.of("a", "c"),
            Set.of("b", "c"),
            Set.of("a", "b", "c"));
    }
}