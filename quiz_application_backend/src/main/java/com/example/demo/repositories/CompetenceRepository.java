package com.example.demo.repositories;

import com.example.demo.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    List<Competence> findByThemeIdAndRoleIdAndLevelId(Long themeId, Long roleId, Long levelId);

    List<Competence> findByNameContainingIgnoreCaseAndThemeIdAndRoleIdAndLevelId(String name, Long themeId, Long roleId,
            Long levelId);
}
