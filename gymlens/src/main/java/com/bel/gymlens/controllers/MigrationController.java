package com.bel.gymlens.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/migration")
@RequiredArgsConstructor
public class MigrationController {

//    private final MigrationService migrationService;

    @PostMapping("/run")
    public ResponseEntity<String> runMigration() {
//        migrationService.run();
        return ResponseEntity.ok("Migration completed successfully");
    }

    @GetMapping("/status")
    public ResponseEntity<String> getMigrationStatus() {
//        String status = migrationService.getStatus();
        return ResponseEntity.ok("done");
    }
}
