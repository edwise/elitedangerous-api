package com.edwise.elitedangerous.controller;

import com.edwise.elitedangerous.bean.SystemPair;
import com.edwise.elitedangerous.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/systempair")
public class SystemPairController {

    private SystemService systemService;

    @Autowired
    public SystemPairController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping
    public ResponseEntity<List<SystemPair>> getAllSystems() {
        List<SystemPair> systemPairs = systemService.obtainClosestLonelySystems();
        return new ResponseEntity<>(systemPairs, HttpStatus.OK);
    }
}
