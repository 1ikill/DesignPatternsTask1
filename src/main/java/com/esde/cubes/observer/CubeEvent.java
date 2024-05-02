package com.esde.cubes.observer;

import com.esde.cubes.model.Cube;
import java.util.EventObject;

public class CubeEvent extends EventObject {
    public CubeEvent(Cube source){
        super(source);
    }

    @Override
    public Cube getSource(){
        return (Cube)super.getSource();
    }
}
