package com.aleksnose.hoteru.Mapper;

import com.aleksnose.hoteru.DTO.RoomDTO;
import com.aleksnose.hoteru.models.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "idTargetRoom", source = "targetRoom.id")
    RoomDTO roomToRoomDTO(Room entity);

    @Mapping(target = "targetRoom.id", source = "idTargetRoom")
    Room roomDTOToRoom(RoomDTO componentDto);
}
