package com.js.effectivejava.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamAdapter {

    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
