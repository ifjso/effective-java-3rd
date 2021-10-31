package com.js.effectivejava.item47;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubListsTest {

    @Test
    @DisplayName("부분리스트를 반환한다.")
    void testOf() {
        // given
        List<String> list = List.of("a", "b", "c");

        // when
        List<List<String>> actual = SubLists.of(list)
            .collect(Collectors.toList());

        // then
        assertThat(actual).hasSize(7);
        assertThat(actual).containsOnlyOnce(
            List.of(),
            List.of("a"),
            List.of("a", "b"),
            List.of("b"),
            List.of("b", "c"),
            List.of("c"),
            List.of("a", "b", "c"));
    }

    @Test
    @DisplayName("부분리스트를 반환한다.")
    void testAtOnceOf() {
        // given
        List<String> list = List.of("a", "b", "c");

        // when
        List<List<String>> actual = SubLists.atOnceOf(list)
            .collect(Collectors.toList());

        // then
        assertThat(actual).hasSize(7);
        assertThat(actual).containsOnlyOnce(
            List.of(),
            List.of("a"),
            List.of("a", "b"),
            List.of("b"),
            List.of("b", "c"),
            List.of("c"),
            List.of("a", "b", "c"));
    }
}