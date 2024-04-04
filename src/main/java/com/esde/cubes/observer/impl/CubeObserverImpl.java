package com.esde.cubes.observer.impl;

import com.esde.cubes.model.Cube;
import com.esde.cubes.model.CubeState;
import com.esde.cubes.model.Warehouse;
import com.esde.cubes.observer.CubeObserver;
import com.esde.cubes.service.CubeService;
import com.esde.cubes.service.impl.CubeServiceImpl;

public class CubeObserverImpl implements CubeObserver {

    @Override
    public void update(Cube cube) {
        CubeState state = CubeState.detect(cube);
        CubeService service = new CubeServiceImpl();
        double volume = service.volume(cube);
        double surfaceArea = service.surfaceArea(cube);
        int key = cube.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, volume);
        warehouse.put(key, surfaceArea);
    }
}
