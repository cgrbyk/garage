package com.streamdelta.garage.model;
/*
 * Cagri.biyik 5/16/21
 */

public class Jeep extends Unit {

    public Jeep(String plate, String color) {
        super(plate, color);
    }

    @Override
    public int getSlot() {
        return 2;
    }
}
