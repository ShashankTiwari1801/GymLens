package com.bel.gymlens.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "calorie_records")
@Data
public class CalorieRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

    @Column(name = "burned", nullable = false)
    private Double burned;

    @Column(name = "exercise_type")
    private String exerciseType;
}
