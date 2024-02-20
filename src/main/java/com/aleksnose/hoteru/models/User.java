package com.aleksnose.hoteru.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private String Name;
    private String Surname;
    private Boolean IsWorker;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IdUser")
    private Set<WorkerInHotel> workersInHotels;

    public Set<WorkerInHotel> getWorkersInHotels() {
        return workersInHotels;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public Boolean getWorker() {
        return IsWorker;
    }
}
