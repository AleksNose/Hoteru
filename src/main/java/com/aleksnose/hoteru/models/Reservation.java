package com.aleksnose.hoteru.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private Integer IdUser;
    private LocalDate DateFrom;
    private LocalDate DateTo;
    private Integer IdRoom;
}
