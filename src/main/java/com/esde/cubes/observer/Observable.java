package com.esde.cubes.observer;

public interface Observable {
    void attach();
    void detach();
    void notifyObservers();
}