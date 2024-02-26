package com.aleksnose.hoteru.service;

import com.aleksnose.hoteru.models.*;
import com.aleksnose.hoteru.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.io.InvalidClassException;
import java.util.HashSet;
import java.util.Set;

@Service
public class HotelService {
    private HotelRepository repository;

    private HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public Hotel getHotelById(Integer id) throws InvalidClassException {

        var hotel = repository.findById(id);
        if (hotel.isPresent())
        {
            return hotel.get();
        }

        throw new InvalidClassException("Hotel isn't present");
    }

    public Set<TargetRoom> getTargetRoomsByHotelId(Integer id) throws InvalidClassException {
        var hotel = getHotelById(id);
        return hotel.getTargetRooms();
    }

    public Set<Hotel> getWorkingHotelsBy(User user) {
        if (!user.getIsWorker()) {
            System.out.println("user isnt worker");
        }

        Set<Hotel> hotels = new HashSet<>();
        for (var workersInHotel : user.getWorkersInHotels()) {
            hotels.add(repository.findById(workersInHotel.getId()).get());
        }

        return hotels;
    }
}
