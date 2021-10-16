package com.js.effectivejava.item30;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class RecursiveTypeBoundTest {

    @Test
    @DisplayName("최대값을 반환해야한다.")
    void test_max() {
        List<String> strings = List.of("a", "c", "b");

        Optional<String> actual = RecursiveTypeBound.max(strings);

        assertThat(actual.get()).isEqualTo("c");
    }

    @Test
    @DisplayName("빈 리스트일 경우 빈 Optional을 반환한다.")
    void test_max_when_empty_list_then_return_empty_optional() {
        List<String> strings = List.of();

        Optional<String> actual = RecursiveTypeBound.max(strings);

        assertThat(actual).isNotPresent();
    }
}