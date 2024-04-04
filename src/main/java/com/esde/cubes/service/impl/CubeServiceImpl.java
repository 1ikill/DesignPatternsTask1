package com.esde.cubes.service.impl;

import com.esde.cubes.model.Cube;
import com.esde.cubes.service.CubeService;

public class CubeServiceImpl implements CubeService {
    @Override
    public double volume(Cube cube) {
        double volume = Math.pow(cube.getSide(), 3);
        return volume; //todo
    }

    @Override
    public double surfaceArea(Cube cube) {
        double surfaceArea = 6 * Math.pow(cube.getSide(), 2);
        return surfaceArea; //todo
    }
}
