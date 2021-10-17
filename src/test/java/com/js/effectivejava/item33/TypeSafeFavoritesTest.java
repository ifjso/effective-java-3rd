package com.js.effectivejava.item33;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TypeSafeFavoritesTest {

    @Test
    @DisplayName("ParameterizedType 조회 시 성공한다.")
    void givenParameterizedType_whenGetFavorite_thenSucceed() {
        // given
        TypeSafeFavorites favorites = new TypeSafeFavorites();
        favorites.putFavorite(new TypeReference<>() {}, List.of(List.of("a", "b")));

        // when
        List<List<String>> actual = favorites.getFavorite(new TypeReference<>() {});

        // then
        assertThat(actual.get(0)).containsExactly("a", "b");
    }

    @Test
    @DisplayName("Type 조회 시 성공한다.")
    void givenType_whenGetFavorite_thenSucceed() {
        // given
        TypeSafeFavorites favorites = new TypeSafeFavorites();
        favorites.putFavorite(new TypeReference<>() {}, 1);

        // when
        int actual = favorites.getFavorite(new TypeReference<>() {});

        // then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("타입에 해당하는 값이 없을 경우 null을 반환한다.")
    void givenNoValue_whenGetFavorite_thenReturnNull() {
        // given
        TypeSafeFavorites favorites = new TypeSafeFavorites();

        // when
        List<String> actual = favorites.getFavorite(new TypeReference<>() {});

        // then
        assertThat(actual).isNull();
    }
}