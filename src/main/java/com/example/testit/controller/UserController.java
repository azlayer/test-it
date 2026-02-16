package com.example.testit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/login")
    public ResponseEntity<Void> user() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/user/me")
    public String userEndpoint() {
        return "Accès USER, MANAGER ou bien ADMIN";
    }

    @GetMapping("/manager/config")
    @PreAuthorize("hasRole('ADMIN')")
    public String managerEndpoint() {
        return "Accès MANAGER";
    }

    @GetMapping("/admin/config")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
        return "Accès ADMIN";
    }
}