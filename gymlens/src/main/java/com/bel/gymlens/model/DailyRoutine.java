package com.bel.gymlens.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "daily_routine")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DailyRoutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "exercise_id")
    private Integer exerciseId;
}
