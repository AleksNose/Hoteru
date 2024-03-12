package com.aleksnose.hoteru.controller;

import com.aleksnose.hoteru.service.TownService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/town")
public class TownController {
    private TownService service;

    public TownController(TownService service) {
        this.service = service;
    }
}
