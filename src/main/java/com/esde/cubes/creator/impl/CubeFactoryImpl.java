package com.esde.cubes.creator.impl;

import com.esde.cubes.creator.CubeFactory;
import com.esde.cubes.model.Cube;
import com.esde.cubes.util.TxtParser;

import java.util.List;

public class CubeFactoryImpl implements CubeFactory {
    @Override
    public Cube createCube(String name, double x, double y, double z, double side) {
        return new Cube(name, x, y, z, side);
    }

    @Override
    public List<Cube> createCubes(String file){
        TxtParser parser = new TxtParser();
        List<Cube> cubes = parser.parseCubesTxt(file);
        return cubes;
    }
}
