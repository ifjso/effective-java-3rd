package com.js.effectivejava.item83;

public class LazyInitHolder {

    public static LazyInitHolder getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static final LazyInitHolder instance = new LazyInitHolder();
    }
}
