package com.bel.gymlens.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "weight")
@Data
public class BodyWeight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "weight")
    private Double weight;
}
