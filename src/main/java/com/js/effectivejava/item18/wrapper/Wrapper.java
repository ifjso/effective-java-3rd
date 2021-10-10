package com.js.effectivejava.item18.wrapper;

/**
 * https://stackoverflow.com/questions/28254116/wrapper-classes-are-not-suited-for-callback-frameworks
 */
public class Wrapper implements SomethingWithCallback {

    private final SomethingWithCallback wrappedObject;

    public Wrapper(SomethingWithCallback wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    @Override
    public void doSomething() {
        wrappedObject.doSomething();
    }

    @Override
    public void call() {
        System.out.println("Wrapper call.");
    }
}
