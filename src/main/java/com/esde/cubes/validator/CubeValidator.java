package com.esde.cubes.validator;

import com.esde.cubes.model.Cube;
import com.esde.cubes.model.CubeState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class CubeValidator {
    private static final Logger logger = LogManager.getLogger();
    public boolean isValid(Double[] params){
        boolean valid = true;
        CubeState currentState = CubeState.detect(new Cube(params[0], params[1], params[2], params[3]));
        if (currentState == CubeState.INVALID) {
            valid = false;
            logger.error("Invalid triangle data: " + Arrays.toString(params));
        }
        return valid;
    }
}
