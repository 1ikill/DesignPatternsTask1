package com.esde.cubes.creator.impl;

import com.esde.cubes.creator.CubeFactory;
import com.esde.cubes.exception.InvalidCubeDataException;
import com.esde.cubes.model.Cube;
import com.esde.cubes.util.TxtParser;
import com.esde.cubes.validator.CubeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class CubeFactoryImpl implements CubeFactory {

    private static final Logger logger = LogManager.getLogger();
    @Override
    public Cube createCube(double x, double y, double z, double side) {
        return new Cube(x, y, z, side);
    }

    @Override
    public List<Cube> createCubes(String file) {
        List<Cube> cubes = new ArrayList<>();
        List<Double[]> cubeData;
        CubeValidator cubeValidator = new CubeValidator();
        try {
            cubeData = TxtParser.parseCubesTxt(file);
        } catch (InvalidCubeDataException e){
            logger.error(e);
            throw new RuntimeException(e);
        }
        for (Double[] params : cubeData) {
            if (cubeValidator.isValid(params)){
                Cube cube = new Cube(params[0], params[1], params[2], params[3]);
                cubes.add(cube);
            }
        }
        logger.info("cubes created successfully");
        return cubes;
    }
}
