package com.js.effectivejava.item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TransferTo {

    public static void main(String[] args) throws IOException {
        try (InputStream in = new URL(args[0]).openStream()) {
            in.transferTo(System.out);
        }
    }
}
