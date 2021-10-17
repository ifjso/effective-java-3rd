package com.js.effectivejava.item33;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FavoritesTest {

    @ParameterizedTest
    @MethodSource("provideTypesAndValues")
    @DisplayName("타입에 해당하는 값을 저장하고 조회한다.")
    <T> void whenPutAndGetFavorite_thenSucceed(Class<T> type, T value) {
        // given
        Favorites favorites = new Favorites();
        favorites.putFavorite(type, value);

        // when
        T favorite = favorites.getFavorite(type);

        // then
        assertThat(favorite).isEqualTo(value);
    }

    static Stream<Arguments> provideTypesAndValues() {
        return Stream.of(
                Arguments.of(Integer.class, 1),
                Arguments.of(String.class, "a"));
    }

    @ParameterizedTest
    @MethodSource("provideTypesAndDifferentTypesOfValues")
    @DisplayName("타입이 다른 값을 저장하면 ClassCastException 예외가 발생한다.")
    <T> void givenDifferentTypesOfValues_whenPutFavorite_thenThrowsClassCastException(Class<T> type, T value) {
        // given
        Favorites favorites = new Favorites();

        // when & then
        assertThatThrownBy(() -> favorites.putFavorite(type, value))
                .isInstanceOf(ClassCastException.class);
    }

    static Stream<Arguments> provideTypesAndDifferentTypesOfValues() {
        return Stream.of(
                Arguments.of(Integer.class, "a"),
                Arguments.of(String.class, 1));
    }

    @Test
    @DisplayName("타입에 해당하는 값이 없을 경우 null을 반환한다.")
    void givenNoValue_whenGetFavorite_thenReturnNull() {
        // given
        Favorites favorites = new Favorites();

        // when
        String actual = favorites.getFavorite(String.class);

        // then
        assertThat(actual).isNull();
    }
}