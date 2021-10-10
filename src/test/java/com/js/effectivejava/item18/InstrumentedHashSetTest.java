package com.js.effectivejava.item18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstrumentedHashSetTest {

    @Test
    @DisplayName("HashSet을 상속할 경우 요소 추가 카운트가 두배로 계산된다.")
    void test_addAll() {
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
        set.addAll(List.of("a", "b", "c"));

        assertThat(set.getAddCount()).isEqualTo(6);
    }
}