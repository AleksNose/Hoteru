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
    private Integer IdWorkerInHotel;
    private Integer IdHotel;
    private Integer IdUser;
    private boolean IsAdmin;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "Id")
    private User user;

    public User getUser() {
        return user;
    }
}
