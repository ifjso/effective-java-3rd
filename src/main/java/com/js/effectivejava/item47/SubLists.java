package com.js.effectivejava.item47;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubLists {

    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(Stream.of(List.of()),
                prefixes(list).flatMap(SubLists::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
            .mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size())
            .mapToObj(start -> list.subList(start, list.size()));
    }

    public static <E> Stream<List<E>> atOnceOf(List<E> list) {
        return IntStream.range(0, list.size())
            .mapToObj(start ->
                IntStream.rangeClosed((int) (start + Math.signum(start)), list.size())
                    .mapToObj(end -> list.subList(start, end)))
            .flatMap(x -> x);
    }
}
