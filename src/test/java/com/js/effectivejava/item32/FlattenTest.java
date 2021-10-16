package com.js.effectivejava.item32;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FlattenTest {

    @Test
    @DisplayName("가변 인수를 이용한 flatten이 성공한다.")
    void whenFlatten_thenSucceed() {
        List<String> actual = Flatten.flatten(List.of("1"), List.of("2"), List.of("3"));
        assertThat(actual).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("리스트를 이용한 flatten이 성공한다.")
    void whenFlattenWithList_thenSucceed() {
        List<String> actual = Flatten.flattenWithList(List.of(List.of("1"), List.of("2"), List.of("3")));
        assertThat(actual).containsExactly("1", "2", "3");
    }
}