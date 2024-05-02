package com.esde.cubes.service.impl;

import com.esde.cubes.model.Cube;
import com.esde.cubes.model.CubeState;
import com.esde.cubes.service.CubeService;

public class CubeServiceImpl implements CubeService {
    @Override
    public double volume(Cube cube) {
        double volume = -1;
        if (cube.getState()!= CubeState.INVALID){
            volume = Math.pow(cube.getSide(), 3);
        }
        return volume;
    }

    @Override
    public double surfaceArea(Cube cube) {
        double surfaceArea = -1;
        if (cube.getState()!= CubeState.INVALID){
            surfaceArea = 6 * Math.pow(cube.getSide(), 2);
        }
        return surfaceArea;
    }
}
