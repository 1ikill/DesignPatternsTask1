package com.esde.cubes.creator;

import com.esde.cubes.model.Cube;

import java.util.List;

public interface CubeFactory {
    List<Cube> createCubes(String file);
    Cube createCube(String name, double x, double y, double z, double side);
}
