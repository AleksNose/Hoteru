package com.aleksnose.hoteru.controller;

import com.aleksnose.hoteru.DTO.ComponentDTO;
import com.aleksnose.hoteru.DTO.RoomDTO;
import com.aleksnose.hoteru.DTO.TargetRoomDTO;
import com.aleksnose.hoteru.Mapper.ComponentMapper;
import com.aleksnose.hoteru.Mapper.RoomMapper;
import com.aleksnose.hoteru.Mapper.TargetRoomMapper;
import com.aleksnose.hoteru.service.TargetRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/targetroom")
public class TargetRoomController {
    private TargetRoomService service;

    public TargetRoomController(TargetRoomService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public TargetRoomDTO getTargetRoomById(@PathVariable Integer id) {
        var targetroom = service.getTargetRoomById(id);
        return TargetRoomMapper.INSTANCE.targetRoomToTargetRoomDTO(targetroom);
    }

    @GetMapping(path = "/{id}/rooms")
    public Set<RoomDTO> getRoomsByIdTargetRoom(@PathVariable Integer id) {
        var rooms = service.getRoomsByIdTargetRoom(id);
        return rooms.stream().map(RoomMapper.INSTANCE::roomToRoomDTO).collect(Collectors.toSet());
    }

    @GetMapping(path = "/{id}/components")
    public Set<ComponentDTO> getComponentByIdTargetRoom(@PathVariable Integer id) {
        var components = service.getComponentByIdTargetRoom(id);
        return components.stream().map(ComponentMapper.INSTANCE::componentToComponentDTO).collect(Collectors.toSet());
    }
}
