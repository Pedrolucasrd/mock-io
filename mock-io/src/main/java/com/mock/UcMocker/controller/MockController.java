package com.mock.UcMocker.controller;

import com.mock.UcMocker.model.HttpMethod;
import com.mock.UcMocker.model.MockStandard;
import com.mock.UcMocker.model.dto.ContentRequest;
import com.mock.UcMocker.service.MockStandardService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MockController {


    @Autowired
    private MockStandardService mockStandardService;
    @GetMapping("teste")
    public String mock(){
        return "teste";
    }

    @PostMapping("create-mock-standard/{mockName}")
    public ResponseEntity<MockStandard> createMockStandard(
            @PathVariable String mockName,
            @RequestParam Map<String, String> queryParams,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\"key\":\"value\"}"))
            ) @RequestBody String mockContent){

        return mockStandardService.createMockStandard(mockName, mockContent, queryParams);
    }

    @GetMapping("src/{mockName}")
    public ResponseEntity<String> srcMockStandard(
            @PathVariable String mockName,
            @RequestParam Map<String, String> params){
        return mockStandardService.srcMockStandard(mockName);
    }
}
