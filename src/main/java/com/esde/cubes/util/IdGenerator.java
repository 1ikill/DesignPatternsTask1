package com.esde.cubes.util;

public class IdGenerator {
    private static int currentId;

    public static int increment() {
        return ++currentId;
    }
}
