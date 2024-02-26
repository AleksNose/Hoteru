package com.aleksnose.hoteru.service;

import com.aleksnose.hoteru.models.Hotel;
import com.aleksnose.hoteru.models.Reservation;
import com.aleksnose.hoteru.models.User;
import com.aleksnose.hoteru.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.InvalidClassException;
import java.util.Set;

@Service
public class UserService {
    public static User loginUser;
    private UserRepository userRepository;
    private HotelService hotelService;
    public UserService(UserRepository userRepository, HotelService hotelService) {
        this.userRepository = userRepository;
        this.hotelService = hotelService;
    }

    public void login(String name, String surname) {
        var foundUser = userRepository.findByNameAndSurname(name, surname);
        if (foundUser == null) return;
        loginUser = foundUser;
    }

    public void logout() {
        loginUser = null;
    }

    public Set<Reservation> getReservations() {
        return loginUser.getReservations();
    }

    public Set<Hotel> getWorkedHotelsByUser() {
        return hotelService.getWorkingHotelsBy(loginUser);
    }
}
