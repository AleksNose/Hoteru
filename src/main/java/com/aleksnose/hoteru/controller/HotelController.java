package com.aleksnose.hoteru.controller;

import com.aleksnose.hoteru.models.Reservation;
import com.aleksnose.hoteru.models.Room;
import com.aleksnose.hoteru.service.HotelService;
import com.aleksnose.hoteru.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    private HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

}
