package com.streamdelta.garage.model;
/*
 * Cagri.biyik 5/16/21
 */

public abstract class Unit {

    private final String plate;

    private final String color;

    public Unit(String plate, String color) {
        this.plate = plate;
        this.color = color;
    }

    public String getPlate() {
        return this.plate;
    }

    public String getColor() {
        return this.color;
    }

    abstract public int getSlot();
}
