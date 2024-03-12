package com.aleksnose.hoteru.service;

import com.aleksnose.hoteru.models.*;
import com.aleksnose.hoteru.repository.HotelRepository;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private HotelRepository repository;

    private HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public Hotel getHotelById(Integer id) {
        var hotel = repository.findById(id);
        return hotel.get();
    }

    public Set<TargetRoom> getTargetRoomsByHotelId(Integer id) {
        var hotel = getHotelById(id);
        return hotel.getTargetRooms();
    }

    public Set<Hotel> getWorkingHotelsBy(User user) {
        return user.getWorkersInHotels().stream().map(WorkerInHotel::getHotel).collect(Collectors.toSet());
    }

    public Set<User> getWorkersByHotel(Integer id) {
        var hotel = getHotelById(id);
        return hotel.getWorkersData();
    }

    public User getAdminByHotel(Integer id) {
        var hotel = getHotelById(id);
        return hotel.getAdmin();
    }
}
