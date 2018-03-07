package com.edwise.elitedangerous.controller;

import com.edwise.elitedangerous.model.SystemPairModel;
import com.edwise.elitedangerous.model.SystemsQuery;
import com.edwise.elitedangerous.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/closestlonelysystems", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClosestLonelySystemsController {

    private SystemService systemService;

    @Autowired
    public ClosestLonelySystemsController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping
    public ResponseEntity<List<SystemPairModel>> getAllClosestLonelySystems() {
        List<SystemPairModel> systemPairs = systemService.obtainClosestLonelySystems();
        return new ResponseEntity<>(systemPairs, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SystemPairModel>> getAllClosestLonelySystems(@Valid @RequestBody SystemsQuery systemsQuery) {
        if (systemsQuery.getClosestDistance() <= 0) {
            // TODO Improve response
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<SystemPairModel> systemPairs = systemService.obtainClosestLonelySystems(systemsQuery.getAllegiance(),
                                                                                     systemsQuery.getClosestDistance(),
                                                                                     systemsQuery.isWithFactionsAndStations());
        return new ResponseEntity<>(systemPairs, HttpStatus.OK);
    }

    @GetMapping("/onestation")
    public ResponseEntity<List<SystemPairModel>> getAllClosestLonelySystemsOneStation() {
        List<SystemPairModel> systemPairs = systemService.obtainClosestLonelySystemsOneStation();
        return new ResponseEntity<>(systemPairs, HttpStatus.OK);
    }

    @PostMapping(value = "/onestation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SystemPairModel>> getAllClosestLonelySystemsOneStation(@Valid @RequestBody
                                                                                              SystemsQuery systemsQuery) {
        if (systemsQuery.getClosestDistance() <= 0) {
            // TODO Improve response
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<SystemPairModel> systemPairs =
                systemService.obtainClosestLonelySystemsOneStation(systemsQuery.getAllegiance(),
                                                                   systemsQuery.getClosestDistance(),
                                                                   systemsQuery.isWithFactionsAndStations(),
                                                                   systemsQuery.getMinStationDistance());
        return new ResponseEntity<>(systemPairs, HttpStatus.OK);
    }
}
