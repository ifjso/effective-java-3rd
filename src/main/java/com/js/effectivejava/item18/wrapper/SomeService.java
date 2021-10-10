package com.js.effectivejava.item18.wrapper;

public class SomeService {

    public void performAsync(SomethingWithCallback callback) {
        new Thread(() -> {
            perform();
            callback.call();
        }).start();
    }

    private void perform() {
        System.out.println("Service is being performed.");
    }
}
