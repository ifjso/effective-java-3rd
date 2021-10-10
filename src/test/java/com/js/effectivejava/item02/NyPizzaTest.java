package com.js.effectivejava.item02;

import static org.assertj.core.api.Assertions.assertThat;

import com.js.effectivejava.item02.NyPizza.Builder;
import com.js.effectivejava.item02.NyPizza.Size;
import com.js.effectivejava.item02.Pizza.Topping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("NyPizza 값 검증")
public class NyPizzaTest {

  @Test
  @DisplayName("토핑이 있는 경우")
  void check_if_topping_is_not_empty() {
    NyPizza actual = new Builder(Size.LARGE)
        .addTopping(Topping.MUSHROOM)
        .addTopping(Topping.HAM)
        .build();

    assertThat(actual.getToppings()).contains(Topping.MUSHROOM, Topping.HAM);
  }

  @Test
  @DisplayName("토핑이 없는 경우")
  void check_if_topping_is_empty() {
    NyPizza actual = new Builder(Size.MEDIUM).build();

    assertThat(actual.getToppings()).isEmpty();
  }

  @ParameterizedTest
  @EnumSource(NyPizza.Size.class)
  @DisplayName("사이즈")
  void check_all_sizes(NyPizza.Size size) {
    NyPizza actual = new Builder(size).build();

    assertThat(actual.getSize()).isEqualTo(size);
  }
}
