package com.streamdelta.garage.model;
/*
 * Cagri.biyik 5/16/21
 */

public class Truck extends Unit {

    public Truck(String plate, String color) {
        super(plate, color);
    }

    @Override
    public int getSlot() {
        return 4;
    }
}
