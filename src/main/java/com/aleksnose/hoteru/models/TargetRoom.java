package com.aleksnose.hoteru.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class TargetRoom {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    private int CountPeople;
    private int CountTargetRoom;

    @MapKey(name = "IdHotel")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdHotel")
    private Hotel hotel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetRoom", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Room> rooms;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetRoom", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<ComponentsInRoom> componentsInRooms;
}
