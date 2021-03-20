package com.js.effectivejava.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public int getSize() {
        return size;
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Object result = elements[--size];
        elements[size] = null;
        return result;

    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    protected Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
