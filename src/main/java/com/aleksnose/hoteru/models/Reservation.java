package com.aleksnose.hoteru.models;

import jakarta.persistence.*;
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
    private LocalDate DateFrom;
    private LocalDate DateTo;

    @MapKey(name = "IdUser")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdUser")
    private User user;

    @MapKey(name = "IdRoom")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdRoom")
    private Room room;

    public LocalDate getDateFrom() {
        return DateFrom;
    }

    public LocalDate getDateTo() {
        return DateTo;
    }
}
