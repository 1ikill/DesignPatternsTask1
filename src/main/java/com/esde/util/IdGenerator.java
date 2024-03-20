package com.esde.util;

public class IdGenerator {
    private static int currentId;

    public static int increment() {
        return ++currentId;
    }
}
