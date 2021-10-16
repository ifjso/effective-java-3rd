package com.js.effectivejava.item32;

import java.util.ArrayList;
import java.util.List;

public class Flatten {

    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }

        return result;
    }

    static <T> List<T> flattenWithList(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }

        return result;
    }
}
