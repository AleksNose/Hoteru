package com.aleksnose.hoteru.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Town {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private String Name;

    @MapKey(name = "IdCountry")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdCountry")
    private Country country;
}
