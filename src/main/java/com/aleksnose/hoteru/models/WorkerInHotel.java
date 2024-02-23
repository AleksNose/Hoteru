package com.aleksnose.hoteru.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class WorkerInHotel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private boolean IsAdmin;

    @MapKey(name = "IdUser")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdUser")
    private User user;

    @MapKey(name = "IdHotel")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdHotel")
    private Hotel hotel;
}
