package com.js.effectivejava.item6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.Set;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KeySetTest {

  @Test
  @DisplayName("Map.KeySet 메서드는 기존과 같은 객체를 반환한다.")
  void keyset_method_returns_same_object() {
    Map<String, String> strings = Maps.newHashMap("a", "a");
    strings.put("b", "b");

    Set<String> oneSet = strings.keySet();
    Set<String> twoSet = strings.keySet();

    oneSet.clear();

    assertThat(oneSet).isEmpty();
    assertThat(twoSet).isEmpty();
  }
}
