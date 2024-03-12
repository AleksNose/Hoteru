package com.aleksnose.hoteru.controller;

import com.aleksnose.hoteru.service.ReservationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }


}
