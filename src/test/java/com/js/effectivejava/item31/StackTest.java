package com.js.effectivejava.item31;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

    @Test
    @DisplayName("스택에 여러 아이템을 한번에 넣는다.")
    void whenPushAll_thenSucceed() {
        // given
        Stack<Number> stack = new Stack<>();
        List<Integer> integers = List.of(1, 2, 3);

        // when
        stack.pushAll(integers);

        // then
        assertThat(stack.getSize()).isEqualTo(integers.size());
    }

    @Test
    @DisplayName("스택에 여러 아이템을 한번에 꺼낸다.")
    void whenPopAll_thenSucceed() {
        // given
        Stack<Number> stack = new Stack<>();
        List<Integer> integers = List.of(1, 2, 3);
        stack.pushAll(integers);

        List<Object> objects = new ArrayList<>();

        // when
        stack.popAll(objects);

        // then
        assertThat(stack.getSize()).isEqualTo(0);
        assertThat(objects.size()).isEqualTo(integers.size());
    }
}