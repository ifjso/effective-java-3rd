package com.js.effectivejava.item31;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class RecursiveTypeBoundTest {

    @Test
    @DisplayName("최대값을 반환해야한다.")
    void test_max() {
        List<Box> boxes = List.of(Box.from(1), Box.from(3), Box.from(2));

        Optional<Box> actual = RecursiveTypeBound.max(boxes);

        assertThat(actual.get().getPrice()).isEqualTo(3);
    }

    @Test
    @DisplayName("빈 리스트일 경우 빈 Optional을 반환한다.")
    void test_max_when_empty_list_then_return_empty_optional() {
        List<Box> boxes = List.of();

        Optional<Box> actual = RecursiveTypeBound.max(boxes);

        assertThat(actual).isNotPresent();
    }

    static class Box extends Item {
        Box(int price) {
            super(price);
        }

        static Box from(int price) {
            return new Box(price);
        }
    }

    static class Item implements Comparable<Item> {
        private int price;

        Item(int price) {
            this.price = price;
        }

        int getPrice() {
            return price;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(price, o.price);
        }
    }
}