package com.bel.gymlens.repository;

import com.bel.gymlens.model.ExerciseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExerciseRecordRepository
        extends JpaRepository<ExerciseRecord, Long> {

    List<ExerciseRecord> findByExerciseId(String exerciseId);
    List<ExerciseRecord> findByDate(String date);
    List<ExerciseRecord> findByExerciseIdOrderByDateAsc(String exerciseId);
}
