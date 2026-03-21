package com.bel.gymlens.service;

import com.bel.gymlens.model.*;
import com.bel.gymlens.repository.*;

import com.bel.gymlens.repository.ExerciseRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MigrationService {

    private final ExerciseRecordRepository exerciseRecordRepository;
    private final BodyWeightRepository bodyWeightRepository;
    private final CalorieRecordRepository calorieRecordRepository;
    private final DailyRoutineRepository dailyRoutineRepository;
    private final UserInfoRepository userInfoRepository;

    private static final String DB_PATH = "src/main/resources/data/WorkoutData.db";

    public String run() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH)) {
//            log.info("Connected to SQLite database");

            migrateExerciseRecords(conn);
            migrateBodyWeight(conn);
            migrateCalorieRecords(conn);
            migrateDailyRoutine(conn);
            migrateUserInfo(conn);

//            log.info("Migration completed successfully");
            return "Migration completed successfully";

        } catch (SQLException e) {
//            log.error("Migration failed: {}", e.getMessage());
            return "Migration failed: " + e.getMessage();
        }
    }

    private void migrateExerciseRecords(Connection conn) throws SQLException {
        String sql = "SELECT * FROM exercise_records";
        List<ExerciseRecord> records = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ExerciseRecord record = new ExerciseRecord();
                record.setDate(rs.getString("date"));
                record.setExerciseId(rs.getString("exercise_id"));
                record.setWeight(rs.getDouble("weight"));
                record.setReps(rs.getInt("reps"));
                records.add(record);
            }
        }

        exerciseRecordRepository.saveAll(records);
//        log.info("Migrated {} exercise records", records.size());
    }

    private void migrateBodyWeight(Connection conn) throws SQLException {
        String sql = "SELECT * FROM weight";
        List<BodyWeight> records = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                try {
                    BodyWeight record = new BodyWeight();
                    record.setDate(rs.getString("date"));
                    record.setWeight(rs.getDouble("weight"));
                    records.add(record);
                } catch (Exception e) {
                    log.error("Failed to map row: {}", e.getMessage());
                }
            }
        }

        log.info("About to save {} body weight records", records.size());
        bodyWeightRepository.saveAll(records);
        log.info("Saved {} body weight records", records.size());
    }

    private void migrateCalorieRecords(Connection conn) throws SQLException {
        String sql = "SELECT * FROM calorie_records";
        List<CalorieRecord> records = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                CalorieRecord record = new CalorieRecord();
                record.setTimestamp(rs.getString("timestamp"));
                record.setBurned(rs.getDouble("burned"));
                record.setExerciseType(rs.getString("exercise_type"));
                records.add(record);
            }
        }

        calorieRecordRepository.saveAll(records);
//        log.info("Migrated {} calorie records", records.size());
    }

    private void migrateDailyRoutine(Connection conn) throws SQLException {
        String sql = "SELECT * FROM daily_routine";
        List<DailyRoutine> records = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                DailyRoutine record = new DailyRoutine();
                record.setDayOfWeek(rs.getInt("day_of_week"));
                record.setExerciseId(rs.getInt("exercise_id"));
                records.add(record);
            }
        }

        dailyRoutineRepository.saveAll(records);
//        log.info("Migrated {} daily routine records", records.size());
    }

    private void migrateUserInfo(Connection conn) throws SQLException {
        String sql = "SELECT * FROM user_info";
        List<UserInfo> records = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                UserInfo record = new UserInfo();
                record.setName(rs.getString("name"));
                record.setHeight(rs.getDouble("height"));
                record.setAge(rs.getInt("age"));
                records.add(record);
            }
        }

        userInfoRepository.saveAll(records);
//        log.info("Migrated {} user info records", records.size());
    }

    public String getStatus() {
        long exerciseCount = exerciseRecordRepository.count();
        long weightCount = bodyWeightRepository.count();
        long calorieCount = calorieRecordRepository.count();

        if (exerciseCount == 0) return "Not migrated yet";
        return String.format("Migrated — %d exercise records, %d weight records, %d calorie records",
                exerciseCount, weightCount, calorieCount);
    }
}
