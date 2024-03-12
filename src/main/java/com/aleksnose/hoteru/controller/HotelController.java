package com.aleksnose.hoteru.controller;

import com.aleksnose.hoteru.DTO.HotelDTO;
import com.aleksnose.hoteru.DTO.TargetRoomDTO;
import com.aleksnose.hoteru.Mapper.HotelMapper;
import com.aleksnose.hoteru.Mapper.TargetRoomMapper;
import com.aleksnose.hoteru.models.User;
import com.aleksnose.hoteru.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    private HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public HotelDTO getHotel(@PathVariable Integer id) {
        var hotel = service.getHotelById(id);
        return HotelMapper.INSTANCE.hotelToHotelDTO(hotel);
    }

    @GetMapping(path = "/{id}/targetrooms")
    public Set<TargetRoomDTO> getRoomsForHotel(@PathVariable Integer id) {
        var roomsForHotel = service.getTargetRoomsByHotelId(id);
        return roomsForHotel.stream().map(TargetRoomMapper.INSTANCE::targetRoomToTargetRoomDTO).collect(Collectors.toSet());
    }

    @GetMapping(path = "/{id}/workers")
    public Set<User> getWorkersByHotel(@PathVariable Integer id) {
        return service.getWorkersByHotel(id);
    }

    @GetMapping(path = "/{id}/admin")
    public User getAdminByHotel(@PathVariable Integer id) {
        return service.getAdminByHotel(id);
    }
}
