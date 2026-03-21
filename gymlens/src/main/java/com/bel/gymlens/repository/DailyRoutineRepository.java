package com.bel.gymlens.repository;

import com.bel.gymlens.model.DailyRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DailyRoutineRepository
        extends JpaRepository<DailyRoutine, Long> {

    List<DailyRoutine> findByDayOfWeek(Integer dayOfWeek);
}
