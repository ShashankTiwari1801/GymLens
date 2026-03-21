package com.bel.gymlens.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_info")
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private Double height;

    @Column(name = "age")
    private Integer age;
}
