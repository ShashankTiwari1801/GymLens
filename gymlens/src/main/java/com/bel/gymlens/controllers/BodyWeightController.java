package com.bel.gymlens.controllers;

import com.bel.gymlens.dto.response.ApiResponse;
import com.bel.gymlens.model.BodyWeight;
import com.bel.gymlens.model.UserInfo;
import com.bel.gymlens.repository.BodyWeightRepository;
import com.bel.gymlens.repository.UserInfoRepository;
import com.bel.gymlens.service.BodyWeightService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/analytics/bodyweight")
@RequiredArgsConstructor
public class BodyWeightController {

    private final BodyWeightService bodyWeightService;
    private final BodyWeightRepository bodyWeightRepository;
    private final UserInfoRepository userInfoRepository;


    @GetMapping
    public ResponseEntity<ApiResponse<List<BodyWeight>>> getBodyWeightHistory() {
        return ResponseEntity.ok(ApiResponse.success(bodyWeightService.getHistory()));
    }

    @GetMapping("/recent")
    public ResponseEntity<List<BodyWeight>> getRecentWeights() {
        return ResponseEntity.ok(bodyWeightService.getRecentWeights());
    }

    @GetMapping("/correlation")
    public ResponseEntity<ApiResponse<String>> getCorrelation() {
        return ResponseEntity.ok(ApiResponse.success("Coming soon"));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(bodyWeightService.getCount());
    }

    @GetMapping("/all")
    public ResponseEntity<List<BodyWeight>> getAll() {
        List<BodyWeight> list = bodyWeightRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/userinfo")
    public ResponseEntity<List<UserInfo>> getUserInfo() {
        List<UserInfo> list = userInfoRepository.findAll();
        return ResponseEntity.ok(list);
    }


}
