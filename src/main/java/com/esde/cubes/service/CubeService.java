package com.esde.cubes.service;

import com.esde.cubes.model.Cube;

public interface CubeService {
    double volume(Cube cube);

    double surfaceArea(Cube cube);
}
