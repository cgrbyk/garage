package com.streamdelta.garage.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Cagri.biyik 5/16/21
 */

public class Car extends Unit{

    public Car(String plate, String color) {
        super(plate, color);
    }

    @Override
    public int getSlot() {
        return 1;
    }
}
