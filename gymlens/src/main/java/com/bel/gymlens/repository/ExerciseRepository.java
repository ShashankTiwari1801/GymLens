package com.bel.gymlens.repository;

import com.bel.gymlens.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository
        extends JpaRepository<Exercise, Long> {

    List<Exercise> findByMuscle(String muscle);
    Optional<Exercise> findByExerciseName(String exerciseName);
}
