package com.js.effectivejava.item18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstrumentedSetTest {

    @Test
    @DisplayName("컴포지션으로 Set의 래퍼 클래스를 구현할 경우 요소 추가 카운트가 올바르게 계산된다.")
    void test_addAll() {
        InstrumentedSet<String> set = new InstrumentedSet<>(new HashSet<>());
        set.addAll(List.of("a", "b", "c"));

        assertThat(set.getAddCount()).isEqualTo(3);
    }
}