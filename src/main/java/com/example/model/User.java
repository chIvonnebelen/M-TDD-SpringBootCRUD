package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column()
    private Date fechaIngreso;
    @Column(nullable = false, unique = false, length = 45)
    private String email;
    @Column(length = 15)
    private String password;
    @Column(length = 45, nullable = false, name = "first_name")
    private String firstName;
    @Column(length = 45, nullable = false, name = "last_name")
    private String lastName;
    private boolean enabled;


}
