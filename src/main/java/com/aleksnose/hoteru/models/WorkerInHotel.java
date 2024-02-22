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
    private Long IdWorkerInHotel;
    private Integer IdHotel;
    private boolean IsAdmin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_Id")
    private User user;
}
