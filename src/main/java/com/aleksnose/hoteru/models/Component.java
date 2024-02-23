package com.aleksnose.hoteru.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Component {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private String Name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<ComponentsInRoom> componentsInRooms;
}
