package com.aleksnose.hoteru.Mapper;

import com.aleksnose.hoteru.DTO.HotelDTO;
import com.aleksnose.hoteru.models.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    @Mapping(target = "idTown", source = "town.id")
    HotelDTO hotelToHotelDTO(Hotel entity);

    @Mapping(target = "town.id", source = "idTown")
    Hotel hotelDTOToHotel(HotelDTO componentDto);
}
