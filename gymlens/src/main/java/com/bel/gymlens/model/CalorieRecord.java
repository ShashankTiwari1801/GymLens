package com.bel.gymlens.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "calorie_records")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
