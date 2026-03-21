package com.bel.gymlens.controllers;

import com.bel.gymlens.dto.response.ApiResponse;
import com.bel.gymlens.repository.*;
import com.bel.gymlens.service.MigrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/migration")
@RequiredArgsConstructor
public class MigrationController {

    private final MigrationService migrationService;
    private final ExerciseRecordRepository exerciseRecordRepository;
    private final BodyWeightRepository bodyWeightRepository;
    private final CalorieRecordRepository calorieRecordRepository;
    private  final DailyRoutineRepository dailyRoutineRepository;
    private final UserInfoRepository userInfoRepository;

    @PostMapping("/run")
    public ResponseEntity<String> runMigration() {
        migrationService.run();
        return ResponseEntity.ok("Migration completed successfully");
    }

    @GetMapping("/status")
    public ResponseEntity<String> getMigrationStatus() {
//        String status = migrationService.getStatus();
        return ResponseEntity.ok("done");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<ApiResponse<String>> clearData() {
        exerciseRecordRepository.deleteAll();
        bodyWeightRepository.deleteAll();
        calorieRecordRepository.deleteAll();
        dailyRoutineRepository.deleteAll();
        userInfoRepository.deleteAll();
        return ResponseEntity.ok(ApiResponse.success("All data cleared"));
    }
}
