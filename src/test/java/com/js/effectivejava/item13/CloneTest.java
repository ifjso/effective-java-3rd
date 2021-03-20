package com.js.effectivejava.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("clone() 테스트")
public class CloneTest {

    @Test
    @DisplayName("PhoneNumber")
    void clone_phone_number() {
        PhoneNumber original = new PhoneNumber(1, 1, 1);
        PhoneNumber clone = original.clone();

        assertThat(original == clone).isFalse();
        assertThat(original.hashCode()).isEqualTo(clone.hashCode());
        assertThat(original).isEqualTo(clone);
    }

    @Test
    @DisplayName("Stack")
    void clone_stack() {
        Stack original = new Stack();
        original.push(new Object());
        original.push(new Object());

        Stack clone = original.clone();
        clone.push(new Object());

        assertThat(original == clone).isFalse();
        assertThat(original.getSize()).isEqualTo(2);
        assertThat(clone.getSize()).isEqualTo(3);
    }
}
