package com.js.effectivejava.item33;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeSafeFavorites {

    private final Map<Type, Object> favorites = new HashMap<>();

    public <T> void putFavorite(TypeReference<T> typeRef, T instance) {
        Type type = typeRef.getType();
        Class<T> classType = getClassType(type);
        favorites.put(type, classType.cast(instance));
    }

    public <T> T getFavorite(TypeReference<T> typeRef) {
        Type type = typeRef.getType();
        Class<T> classType = getClassType(type);
        return classType.cast(favorites.get(type));
    }

    @SuppressWarnings("unchecked")
    private <T> Class<T> getClassType(Type type) {
        if (type instanceof ParameterizedType) {
            return (Class<T>) ((ParameterizedType) type).getRawType();
        }

        return (Class<T>) type;
    }
}
