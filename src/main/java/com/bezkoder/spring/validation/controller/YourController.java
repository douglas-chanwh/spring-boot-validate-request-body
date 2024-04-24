package com.bezkoder.spring.validation.controller;

import com.bezkoder.spring.validation.payload.ValidRequestBody;
import com.bezkoder.spring.validation.payload.ValidRequestParams;
import com.bezkoder.spring.validation.payload.YourRequestBody;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class YourController {

    @GetMapping("/endpoint")
    public ResponseEntity<?> getEndpoint(@Valid @RequestBody(required = false) @ValidRequestBody YourRequestBody requestBody) {
        // Process the request
        // ...
        return ResponseEntity.ok().build();
    }


    @GetMapping("/api/users")
    @ValidRequestParams
    public List getUsers(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "sort", required = false) String sortBy,
            @RequestParam(value = "order", required = false) String sortOrder) {
        // Rest of the endpoint logic
        // ...

        return List.of();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}