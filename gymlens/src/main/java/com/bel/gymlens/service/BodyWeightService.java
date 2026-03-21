package com.bel.gymlens.service;
import com.bel.gymlens.model.BodyWeight;
import com.bel.gymlens.repository.BodyWeightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodyWeightService {

    private final BodyWeightRepository bodyWeightRepository;

    public List<BodyWeight> getHistory() {
        return bodyWeightRepository.findAllByOrderByDateAsc();
    }

    public List<BodyWeight> getRecentWeights() {
        return bodyWeightRepository.findTop10ByOrderByDateDesc();
    }

    public Long getCount() {
        return bodyWeightRepository.count();
    }
}
