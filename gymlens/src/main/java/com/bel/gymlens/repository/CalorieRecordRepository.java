package com.bel.gymlens.repository;

import com.bel.gymlens.model.CalorieRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CalorieRecordRepository
        extends JpaRepository<CalorieRecord, Long> {

    List<CalorieRecord> findByExerciseType(String exerciseType);
    List<CalorieRecord> findAllByOrderByTimestampAsc();
}
