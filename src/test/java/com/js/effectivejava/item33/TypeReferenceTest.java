package com.js.effectivejava.item33;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TypeReferenceTest {

    @Test
    @DisplayName("참조하고 있는 타입을 조회한다.")
    void whenGetType_thenSucceed() {
        TypeReference<List<List<String>>> typeRef = new TypeReference<>() {};

        Type type = typeRef.getType();
        assertThat(type.getTypeName()).isEqualTo("java.util.List<java.util.List<java.lang.String>>");

        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        assertThat(actualTypeArguments)
                .extracting(Type::getTypeName)
                .containsExactly("java.util.List<java.lang.String>");
    }
}