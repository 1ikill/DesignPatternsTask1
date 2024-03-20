package com.esde.creator;

import com.esde.model.Cube;
import java.util.List;

public interface CubeFactory {
    List<Cube> createCubes(String file);
    Cube createCube(String name, double x, double y, double z, double side);
}
