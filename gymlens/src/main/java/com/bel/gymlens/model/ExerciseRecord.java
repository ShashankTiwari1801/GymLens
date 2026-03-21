package com.bel.gymlens.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercise_records")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "exercise_id")
    private String exerciseId;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "reps")
    private Integer reps;

}
