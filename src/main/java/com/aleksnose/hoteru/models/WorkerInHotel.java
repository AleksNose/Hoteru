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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdUser", referencedColumnName = "Id", insertable = false, updatable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
