package com.js.effectivejava.item2;

import static org.assertj.core.api.Assertions.assertThat;

import com.js.effectivejava.item2.Pizza.Topping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calzone 값 검증")
public class CalzoneTest {

  @Test
  @DisplayName("토핑이 있는 경우")
  void check_if_topping_is_not_empty() {
    Calzone actual = new Calzone.Builder()
        .addTopping(Topping.ONION)
        .addTopping(Topping.PEPPER)
        .build();

    assertThat(actual.getToppings()).contains(Topping.ONION, Topping.PEPPER);
  }

  @Test
  @DisplayName("토핑이 없는 경우")
  void check_if_topping_is_empty() {
    Calzone actual = new Calzone.Builder().build();

    assertThat(actual.getToppings()).isEmpty();
  }

  @Test
  @DisplayName("소스를 안에 넣은 경우")
  void check_if_sauce_inside() {
    Calzone actual = new Calzone.Builder()
        .sauceInside()
        .build();

    assertThat(actual.isSauceInside()).isTrue();
  }

  @Test
  @DisplayName("소스를 안에 넣지 않은 경우")
  void check_if_no_sauce_inside() {
    Calzone actual = new Calzone.Builder().build();

    assertThat(actual.isSauceInside()).isFalse();
  }
}
