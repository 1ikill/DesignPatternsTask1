package com.esde.cubes.model;

public enum CubeState {
    INVALID, VALID;
    public static CubeState detect(Cube cube){
        return hasPositiveSide(cube) ? VALID : INVALID;
    }

    public static boolean hasPositiveSide(Cube cube){
        return cube.getSide() > 0;
    }
}
