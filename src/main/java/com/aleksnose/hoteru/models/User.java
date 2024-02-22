package com.aleksnose.hoteru.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long Id;
    private String Name;
    private String Surname;
    private Boolean IsWorker;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<WorkerInHotel> workersInHotels;

    public void setWorkersInHotels(Set<WorkerInHotel> workersInHotels) {
        this.workersInHotels = workersInHotels;
    }

    public Set<WorkerInHotel> getWorkersInHotels() {
        return workersInHotels;
    }
}
