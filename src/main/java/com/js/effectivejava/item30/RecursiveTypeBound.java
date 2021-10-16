package com.js.effectivejava.item30;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class RecursiveTypeBound {

    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0)  {
                result = Objects.requireNonNull(e);
            }
        }

        return Optional.ofNullable(result);
    }
}
