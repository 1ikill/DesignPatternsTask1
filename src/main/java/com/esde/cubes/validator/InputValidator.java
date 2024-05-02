package com.esde.cubes.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class InputValidator {
    private static final Logger logger = LogManager.getLogger();

    public boolean hasFourParameters(String[] param) {
        boolean valid = true;
        if (param.length != 4) {
            logger.error("There are not 4 params:" + Arrays.toString(param));
            valid = false;
        }
        return valid;
    }

    public Double[] validParams(String[] params) {
        double centerX;
        double centerY;
        double centerZ;
        double side;
        try {
            centerX = Double.parseDouble(params[0]);
            centerY = Double.parseDouble(params[1]);
            centerZ = Double.parseDouble(params[2]);
            side = Double.parseDouble(params[3]);
        } catch (NumberFormatException e) {
            logger.error("Invalid data: " + Arrays.toString(params));
            return null;
        }
        Double[] cube = new Double[]{centerX, centerY, centerZ, side};
        return cube;
    }
}
