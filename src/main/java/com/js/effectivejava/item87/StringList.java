package com.js.effectivejava.item87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class StringList implements Serializable {

    private transient int size = 0;
    private transient Entry head = null;

    private static class Entry {

        String data;
        Entry next;
        Entry previous;

        public Entry(String data, Entry next, Entry previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    public void add(String s) {
        size++;

        if (Objects.isNull(head)) {
            head = new Entry(s, null, null);
            return;
        }

        Entry last = lastEntry();
        last.next = new Entry(s, null, last);
    }

    private Entry lastEntry() {
        Entry last = head;
        while (Objects.nonNull(last.next)) {
            last = last.next;
        }

        return last;
    }

    public int size() {
        return size;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        for (Entry e = head; e != null; e = e.next) {
            s.writeObject(e.data);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        for (int i = 0; i < numElements; i++) {
            add((String) s.readObject());
        }
    }

    @Override
    public String toString() {
        List<String> s = new ArrayList<>();
        for (Entry e = head; e != null; e = e.next) {
            s.add(e.data);
        }

        return String.join(", ", s);
    }
}
