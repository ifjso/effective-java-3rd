package com.js.effectivejava.item18.wrapper;

public class WrappedObject implements SomethingWithCallback {

    private final SomeService someService;

    public WrappedObject(SomeService someService) {
        this.someService = someService;
    }

    @Override
    public void doSomething() {
        someService.performAsync(this);
    }

    @Override
    public void call() {
        System.out.println("WrappedObject call.");
    }
}
