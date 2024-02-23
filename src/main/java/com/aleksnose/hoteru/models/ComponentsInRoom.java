package com.aleksnose.hoteru.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ComponentsInRoom {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;

    @MapKey(name = "IdTargetRoom")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdTargetRoom")
    private TargetRoom targetRoom;

    @MapKey(name = "IdComponent")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdComponent")
    private Component component;
}
