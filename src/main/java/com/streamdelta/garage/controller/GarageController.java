package com.streamdelta.garage.controller;
/*
 * Cagri.biyik 5/16/21
 */

import com.streamdelta.garage.service.GarageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class GarageController {

    private final static Logger logger = LoggerFactory.getLogger(GarageController.class);

    @Autowired
    private GarageService garageService;

    @RequestMapping(value = "/park", method = RequestMethod.GET)
    public String parkUnit(@RequestParam String plate, @RequestParam String color, @RequestParam String type) {
        logger.info("park request plate {}.", plate);
        return garageService.parkUnit(plate, color, type);
    }

    @RequestMapping(value = "/leave", method = RequestMethod.GET)
    public String leaveUnit(@RequestParam int slot) {
        logger.info("leave request slot {}.", slot);
        return garageService.leaveUnit(slot);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String garageStatus() {
        logger.info("status request");
        return garageService.getStatus();
    }
}
