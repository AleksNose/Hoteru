package com.aleksnose.hoteru.repository;

import com.aleksnose.hoteru.models.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {
}
