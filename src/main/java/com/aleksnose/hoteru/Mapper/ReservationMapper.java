package com.aleksnose.hoteru.Mapper;

import com.aleksnose.hoteru.DTO.ReservationDTO;
import com.aleksnose.hoteru.models.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(target = "idUser", source = "user.id")
    @Mapping(target = "idRoom", source = "room.id")
    ReservationDTO reservationToReservationDTO(Reservation entity);

    @Mapping(target = "user.id", source = "idUser")
    @Mapping(target = "room.id", source = "idRoom")
    Reservation reservationDTOToReservation(ReservationDTO componentDto);
}
