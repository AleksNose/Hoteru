package com.aleksnose.hoteru.models;

import jakarta.persistence.*;

@Entity
@Table(name = User.NAME)
public class User {
    public static final String NAME = "User";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    private String Name;
    private String Surname;
    private Boolean IsWorker;
}
