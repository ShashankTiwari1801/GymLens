package com.bel.gymlens.controllers;

import com.bel.gymlens.model.Exercise;
import com.bel.gymlens.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getExerciseById(@PathVariable Long id) {
        return ResponseEntity.ok(exerciseService.getById(id).getExerciseName());
    }
}
