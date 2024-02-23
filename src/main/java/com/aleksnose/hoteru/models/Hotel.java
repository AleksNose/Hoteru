package com.aleksnose.hoteru.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private String Name;

    @MapKey(name = "IdTown")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdTown")
    private Town town;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<TargetRoom> targetRooms;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<WorkerInHotel> workerInHotels;
}
