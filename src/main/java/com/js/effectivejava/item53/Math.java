package com.js.effectivejava.item53;

public class Math {

    public static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs) {
            if (min > arg) {
                min = arg;
            }
        }

        return min;
    }
}
