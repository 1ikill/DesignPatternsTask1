package com.esde.cubes.util;

import com.esde.cubes.model.Cube;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TxtParser {
    public TxtParser(){
    }

    public List<Cube> parseCubesTxt(String file){
        List<Cube> cubes = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(getClass().getResource(file).toURI()))) {//todo
            lines.forEach(line -> {
                String[] cubeData = line.split(",");
                if (cubeData.length == 5) {
                    String name = cubeData[0].trim();
                    double centerX = Double.parseDouble(cubeData[1].trim());
                    double centerY = Double.parseDouble(cubeData[2].trim());
                    double centerZ = Double.parseDouble(cubeData[3].trim());
                    double side = Double.parseDouble(cubeData[4].trim());

                    Cube cube = new Cube(name, centerX, centerY, centerZ, side);
                    cubes.add(cube);
                } else {
                    System.err.println("Invalid format: " + line);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cubes;
    }
}
