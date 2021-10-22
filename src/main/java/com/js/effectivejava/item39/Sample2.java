package com.js.effectivejava.item39;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {

    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        list.addAll(0, null);
    }
}
