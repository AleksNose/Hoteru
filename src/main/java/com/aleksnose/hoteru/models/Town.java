package com.aleksnose.hoteru.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Town {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private Integer IdCountry;
    private String Name;
}
