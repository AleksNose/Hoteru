package com.aleksnose.hoteru.Mapper;

import com.aleksnose.hoteru.DTO.CountryDTO;
import com.aleksnose.hoteru.models.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDTO countryToCountryDTO(Country entity);

    Country countryDTOToCountry(CountryDTO componentDto);
}
