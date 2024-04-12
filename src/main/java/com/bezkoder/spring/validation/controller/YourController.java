package com.bezkoder.spring.validation.controller;

import com.bezkoder.spring.validation.payload.ValidRequestBody;
import com.bezkoder.spring.validation.payload.YourRequestBody;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Validated
public class YourController {

    @GetMapping("/endpoint")
    public ResponseEntity<?> getEndpoint(@Valid @RequestBody(required = false) @ValidRequestBody YourRequestBody requestBody) {
        // Process the request
        // ...
        return ResponseEntity.ok().build();
    }
}