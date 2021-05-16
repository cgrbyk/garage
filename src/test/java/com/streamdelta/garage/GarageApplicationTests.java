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
        assert garageService.parkUnit(new Car("AA", "Red")).equals("Allocated 1 slot");
        assert garageService.parkUnit(new Jeep("BB", "yel")).equals("Allocated 2 slot");
        assert garageService.parkUnit(new Truck("CC", "grn")).equals("Allocated 4 slot");
        assert garageService.parkUnit(new Truck("DD", "gry")).equals("No space left in garage for unit");
        System.out.println(garageService.getStatus());
        assert garageService.getStatus().equals("AA Red [0]\n" +
                "BB yel [2,3]\n" +
                "CC grn [5,6,7,8]\n");
        assert garageService.leaveUnit(0).equals("AA left");
        System.out.println(garageService.getStatus());
        assert garageService.getStatus().equals("BB yel [2,3]\n" +
                "CC grn [5,6,7,8]\n");
    }

}
