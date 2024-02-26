package com.aleksnose.hoteru.controller;

import com.aleksnose.hoteru.models.Hotel;
import com.aleksnose.hoteru.models.Reservation;
import com.aleksnose.hoteru.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path="/login")
    public void login(String name, String surname) {
        userService.login(name, surname);
    }

    @PostMapping(path="/logout")
    public void logout() {
        userService.logout();
    }

    @GetMapping(path = "/reservations")
    public Set<Reservation> getReservations()
    {
        return userService.getReservations();
    }

    @GetMapping(path = "/worker/hotels")
    public Set<Hotel> getWorkedHotelsByUser()
    {
        return userService.getWorkedHotelsByUser();
    }
}
