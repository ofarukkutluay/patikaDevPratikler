package com.example.arackiralamaportali.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int role_id;

    @Column(name = "role_name")
    private String roleName;

}
