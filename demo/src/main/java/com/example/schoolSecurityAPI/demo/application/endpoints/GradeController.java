package com.example.schoolSecurityAPI.demo.application.endpoints;

import com.example.schoolSecurityAPI.demo.application.dto.GradeDTO;
import com.example.schoolSecurityAPI.demo.domain.Role;
import com.example.schoolSecurityAPI.demo.domain.User;
import com.example.schoolSecurityAPI.demo.domain.service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private GradeService gradeService;

    @PatchMapping("/{studentId}")
    public ResponseEntity<String> updateGrade(@PathVariable Long studentId, @RequestBody GradeDTO grade) {
        // Obtendo o usuário autenticado
        User user = gradeService.getAuthenticatedUser(studentId.toString());

        // Verificando as permissões do usuário
        if (!hasPermissionToUpdateGrade(user, studentId)) {
            throw new AccessDeniedException("Você não tem permissão para alterar esta nota.");
        }

        // Atualizando a nota
        gradeService.updateGrade(studentId, grade.getGrade());
        return ResponseEntity.ok("Nota atualizada com sucesso!");
    }

    // Método para verificar permissões
    private boolean hasPermissionToUpdateGrade(User user, Long studentId) {
        // Apenas professores e coordenadores têm permissão
        if (user.getRole().equals(Role.PROFESSOR)) {
            // Verifica se o professor é responsável pelo aluno
            return gradeService.isProfessorOfStudent(user.getId(), studentId);
        }

        return user.getRole().equals(Role.COORDINATOR);
    }
}
