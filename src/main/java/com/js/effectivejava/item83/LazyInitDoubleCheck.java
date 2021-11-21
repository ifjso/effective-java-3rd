package com.js.effectivejava.item83;

public class LazyInitDoubleCheck {

    private volatile String field;

    public String getField() {
        String result = field;
        if (result != null) {
            return result;
        }

        synchronized(this) {
            if (field == null) {
                field = "field";
            }

            return field;
        }
    }
}
