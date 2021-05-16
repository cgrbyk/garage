package com.streamdelta.garage;

import com.streamdelta.garage.model.Car;
import com.streamdelta.garage.model.Jeep;
import com.streamdelta.garage.model.Truck;
import com.streamdelta.garage.service.GarageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GarageApplicationTests {

    @Autowired
    private GarageService garageService;

    @Test
    void garageTest() {
        garageService.parkUnit(new Car("AA", "Red"));
        garageService.parkUnit(new Jeep("BB", "yel"));
        garageService.parkUnit(new Truck("CC", "grn"));
        garageService.leaveUnit(3);
        garageService.parkUnit(new Car("DD", "gry"));
        System.out.println(garageService.getStatus());
    }

}
