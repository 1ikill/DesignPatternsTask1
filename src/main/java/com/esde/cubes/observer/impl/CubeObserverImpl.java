package com.esde.cubes.observer.impl;

import com.esde.cubes.model.Cube;
import com.esde.cubes.model.Warehouse;
import com.esde.cubes.observer.CubeObserver;
import com.esde.cubes.service.CubeService;
import com.esde.cubes.service.impl.CubeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserverImpl implements CubeObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void update(Cube cube) {
        CubeService service = new CubeServiceImpl();
        double volume = service.volume(cube);
        double surfaceArea = service.surfaceArea(cube);
        int key = cube.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, volume, surfaceArea);
        logger.info("warehouse updated");
    }
}
