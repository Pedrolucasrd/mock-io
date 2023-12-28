package com.mock.UcMocker.service;

import com.mock.UcMocker.model.MockStandard;
import com.mock.UcMocker.model.dto.MockStandardDTO;
import com.mock.UcMocker.repository.MockStandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MockStandardService {

    @Autowired
    private MockStandardRepository mockStandardRepository;

    public ResponseEntity<MockStandard> createMockStandard(String mockName, String mockContent, Map<String, String> queryParams){
        MockStandard mockStandard = new MockStandard(mockName,mockContent, queryParams);
        mockStandardRepository.save(mockStandard);
        return ResponseEntity.ok(mockStandard);
    }

    public ResponseEntity<String> srcMockStandard(String mockName) {
        MockStandard mockStandard = mockStandardRepository.findById(mockName).orElseThrow();
        return ResponseEntity.ok(mockStandard.getMockContent());
    }
}
