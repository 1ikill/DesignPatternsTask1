package com.esde.cubes.main;

import com.esde.cubes.creator.CubeFactory;
import com.esde.cubes.creator.impl.CubeFactoryImpl;
import com.esde.cubes.model.Cube;
import com.esde.cubes.model.Warehouse;
import java.util.List;

public class Main{
    public static void main(String[] args){
        CubeFactory cubeFactory = new CubeFactoryImpl();
        List<Cube> cubes = cubeFactory.createCubes("/resource.txt");

        for (Cube cube : cubes) {
            System.out.println(cube);
        }

        Warehouse warehouse = Warehouse.getInstance();
        Cube ob = cubes.getFirst();
        ob.setSide(50);
        System.out.println(warehouse);
        ob.setSide(40);
        System.out.println(warehouse);

    }
}
