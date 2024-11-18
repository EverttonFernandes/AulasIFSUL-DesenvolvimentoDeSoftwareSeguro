package com.example.schoolSecurityAPI.demo.domain;

public class User {
    private Long id;
    private String name;
    private Role role;
    private String registration;

    public User(Long id, String name, Role role, String registration) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.registration = registration;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public String getRegistration() {
        return registration;
    }
}
