package com.example.schoolSecurityAPI.demo.domain.service;

import com.example.schoolSecurityAPI.demo.domain.User;
import com.example.schoolSecurityAPI.demo.infrastructure.repository.UserRepository;

public class GradeService {

    private final UserRepository userRepository;

    public GradeService(UserRepository userRepositoryImpl) {
        this.userRepository = userRepositoryImpl;
    }

    public User getAuthenticatedUser(String id) {
        return this.userRepository.findUserById(id);
    }


    public void updateGrade(Long studentId, Object grade) {

    }

    public boolean isProfessorOfStudent(Long id, Long studentId) {
        // criar a lógica com calma
        return true;
    }
}
