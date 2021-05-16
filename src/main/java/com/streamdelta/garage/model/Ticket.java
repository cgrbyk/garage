package com.streamdelta.garage.model;
/*
 * Cagri.biyik 5/16/21
 */

import java.util.Date;

public class Ticket {

    private final String id;

    private final int[] slots;

    private final Date parkDate;

    private final String plate;

    private final String Color;

    public Ticket(String id, int[] slots, Date parkDate, String plate, String color) {
        this.id = id;
        this.slots = slots;
        this.parkDate = parkDate;
        this.plate = plate;
        this.Color = color;
    }

    public String getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public int[] getSlots() {
        return slots;
    }

    public Date getParkDate() {
        return parkDate;
    }

    public String getColor() {
        return Color;
    }
}
