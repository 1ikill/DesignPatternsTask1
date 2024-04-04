package com.esde.cubes.model;

import com.esde.cubes.observer.CubeObserver;
import com.esde.cubes.observer.Observable;
import com.esde.cubes.observer.impl.CubeObserverImpl;
import com.esde.cubes.util.IdGenerator;

import java.util.StringJoiner;

public class Cube implements Observable {
    private int id;
    private String name;
    private Dot center;
    private double side;
    private CubeState state= CubeState.INVALID;

    private CubeObserver observer = new CubeObserverImpl();

    public Cube(){}

    public Cube(String name, double x, double y, double z, double side){
        this.id = IdGenerator.increment();
        this.name = name;
        this.center = new Dot(x, y, z);
        this.side = side;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    public Dot getCenter() {
        return center;
    }

    public void setCenter(Dot center) {
        this.center = center;
        notifyObservers();
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
        notifyObservers();
    }

    public CubeState getState() {
        return state;
    }

    public void setState(CubeState state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (id != cube.id) return false;
        if (Double.compare(side, cube.side) != 0) return false;
        if (!name.equals(cube.name)) return false;
        if (!center.equals(cube.center)) return false;
        return state == cube.state;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + center.hashCode();
        temp = Double.doubleToLongBits(side);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + state.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cube.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name=" + name)
                .add("center=" + center)
                .add("side=" + side)
                .add("state=" + state)
                .toString();
    }

    @Override
    public void attach() {
        observer = new CubeObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }
}
