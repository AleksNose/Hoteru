package com.aleksnose.hoteru.service;

import com.aleksnose.hoteru.models.Country;
import com.aleksnose.hoteru.models.Hotel;
import com.aleksnose.hoteru.models.Town;
import com.aleksnose.hoteru.repository.TownRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TownService {
    private TownRepository townRepository;

    public TownService(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    public Town getTownById(Integer id) {
        return townRepository.findById(id).orElse(null);
    }

    public Set<Hotel> getHotelsByIdTown(Integer id) {
        var town = getTownById(id);
        return town != null ? town.getHotels() : null;
    }

    public Country getCountryByIdTown(Integer id) {
        var town = getTownById(id);
        return town != null ? town.getCountry() : null;
    }
}
