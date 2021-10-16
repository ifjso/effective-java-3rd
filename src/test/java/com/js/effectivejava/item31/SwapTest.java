package com.js.effectivejava.item31;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SwapTest {

    @Test
    @DisplayName("리스트에서 임의의 두 위치 값을 swap 하면 서로 값이 바뀌어야 한다.")
    void wheSwap_theSucceed() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        Swap.swap(integers, 0, 1);

        assertThat(integers.get(0)).isEqualTo(2);
        assertThat(integers.get(1)).isEqualTo(1);
    }
}