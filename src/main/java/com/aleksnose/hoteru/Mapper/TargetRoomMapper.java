package com.aleksnose.hoteru.Mapper;

import com.aleksnose.hoteru.DTO.TargetRoomDTO;
import com.aleksnose.hoteru.models.TargetRoom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TargetRoomMapper {
    TargetRoomMapper INSTANCE = Mappers.getMapper(TargetRoomMapper.class);

    @Mapping(target = "idHotel", source = "hotel.id")
    TargetRoomDTO targetRoomToTargetRoomDTO(TargetRoom entity);

    @Mapping(target = "hotel.id", source = "idHotel")
    TargetRoom targetRoomDTOToTargetRoom(TargetRoomDTO componentDto);
}
