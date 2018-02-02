package com.edwise.elitedangerous.controller;

import com.edwise.elitedangerous.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/systems")
public class SystemsController {

    private SystemService systemService;

    @Autowired
    public SystemsController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping
    public ResponseEntity<List<System>> getAllSystems() {
        // TODO implement ?
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }
}
