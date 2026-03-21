package com.bel.gymlens.repository;

import com.bel.gymlens.model.BodyWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BodyWeightRepository
        extends JpaRepository<BodyWeight, Long> {

    List<BodyWeight> findAllByOrderByDateAsc();
    List<BodyWeight> findTop10ByOrderByDateDesc();
}
