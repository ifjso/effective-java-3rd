package com.js.effectivejava.item13;

import java.util.stream.IntStream;

public class HashTable implements Cloneable {
    private Entry[] buckets;

    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            IntStream.range(0, buckets.length).forEach(i -> deepCopy(i, result));
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private void deepCopy(int index, HashTable result) {
        if (buckets[index] != null) {
            result.buckets[index] = buckets[index].deepCopy();
        }
    }

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }
}
