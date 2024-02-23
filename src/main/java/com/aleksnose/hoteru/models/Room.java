package com.aleksnose.hoteru.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private int NrRoom;

    @MapKey(name = "IdTargetRoom")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdTargetRoom")
    private TargetRoom targetRoom;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Reservation> reservations;
}
