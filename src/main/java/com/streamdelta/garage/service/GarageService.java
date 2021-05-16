package com.streamdelta.garage.service;
/*
 * Cagri.biyik 5/16/21
 */

import com.streamdelta.garage.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class GarageService {

    private final static Logger logger = LoggerFactory.getLogger(GarageService.class);

    private final static Ticket[] garage = new Ticket[10];

    public String parkUnit(String plate, String color, String type) {
        switch (type) {
            case "Car": {
                return parkUnit(new Car(plate, color));
            }
            case "Jeep": {
                return parkUnit(new Jeep(plate, color));
            }
            case "Truck": {
                return parkUnit(new Truck(plate, color));
            }
            default: {
                return "Wrong type";
            }
        }
    }

    public String parkUnit(Unit unit) {
        int[] slots = getAvailableSlots(unit.getSlot());
        String result;
        if (slots != null) {
            Ticket ticket = new Ticket(UUID.randomUUID().toString(), slots, new Date(), unit.getPlate(), unit.getColor());
            for (int slot : slots) {
                garage[slot] = ticket;
            }
            result = String.format("Allocated %s slot", slots.length);
            logger.info("Allocated {} slot", slots.length);
        } else {
            result = "No space left in garage for unit";
            logger.info("No space left in garage for unit");
        }
        return result;
    }

    public String leaveUnit(int slot) {
        Ticket ticket = garage[slot];
        if (ticket != null) {

            for (int i = 0; i < garage.length; i++) {
                if (garage[i] != null && garage[i].getPlate().equals(ticket.getPlate()))
                    garage[i] = null;
            }
            return String.format("%s left", ticket.getPlate());
        }
        return "Slot is already empty";

    }

    public String getStatus() {
        StringBuilder status = new StringBuilder();
        String lastPlate = "";
        for (int i = 0; i < garage.length; i++) {
            Ticket temp = garage[i];
            if (temp != null) {
                if (!temp.getPlate().equals(lastPlate)) {
                    lastPlate = temp.getPlate();
                    status.append(temp.getPlate())
                            .append(" ")
                            .append(temp.getColor())
                            .append(" [")
                            .append(i);
                } else {
                    status.append(",")
                            .append(i);
                }
            } else if (!lastPlate.equals("")) {
                status.append("]")
                        .append(System.lineSeparator());
                lastPlate = "";
            }
        }
        return status.toString();
    }

    private int[] getAvailableSlots(int size) {
        int availableSlotCount = 0;
        int[] availableSlots = new int[size];
        boolean isPrevSlotFull = false;
        boolean isNextSlotFull = false;
        for (int i = 0; i < garage.length; i++) {
            if ((i < (garage.length - 1) && garage[i + 1] == null) || (i == garage.length - 1))
                isNextSlotFull = false;
            else
                isNextSlotFull = true;

            if (!isPrevSlotFull && !isNextSlotFull && garage[i] == null) {
                availableSlots[availableSlotCount] = i;
                availableSlotCount++;

                if (availableSlotCount == size)
                    break;
            } else if (garage[i] != null) {
                isPrevSlotFull = true;
                availableSlots = new int[size];
                availableSlotCount = 0;
            } else if (garage[i] == null && isPrevSlotFull)
                isPrevSlotFull = false;
        }

        if (availableSlotCount == size)
            return availableSlots;
        else return null;
    }
}
