package com.example.demo.controllers;

import com.example.demo.model.Theme;
import com.example.demo.model.Role;
import com.example.demo.model.Level;
import com.example.demo.model.Test;
import com.example.demo.repositories.ThemeRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.TestRepository;
import com.example.demo.repositories.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CreateTest {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private NiveauRepository levelRepository;

    @Autowired
    private TestRepository testRepository;

    // Endpoint pour récupérer tous les thèmes (domaines)
    @GetMapping("/themes")
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    // Endpoint pour récupérer les rôles en fonction du thème sélectionné
    @GetMapping("/roles/{themeId}")
    public List<Role> getRolesByThemeId(@PathVariable Long themeId) {
        return roleRepository.findByThemeId(themeId);
    }

    // Endpoint pour récupérer les niveaux en fonction du thème sélectionné
    @GetMapping("/levels/{themeId}")
    public List<Level> getLevelsByThemeId(@PathVariable Long themeId) {
        return levelRepository.findByThemeId(themeId);
    }

    // Endpoint for searching competencies
    @GetMapping("/competencies/search")
    public List<Test> searchCompetencies(@RequestParam String query) {
        return testRepository.findByLanguageContainingIgnoreCase(query);
    }

    // Endpoint pour créer un nouveau test (si nécessaire)
    @PostMapping("/createTest")
    public void createTest(@RequestBody TestRequest testRequest) {
        // Code pour créer et sauvegarder un nouveau test
        // Utilisez testRequest pour obtenir les informations nécessaires
    }

    // Classe interne pour encapsuler les informations de création de test
    public static class TestRequest {
        private String testName;
        private Long themeId;
        private Long roleId;
        private Long levelId;

        // Getters et setters
        public String getTestName() {
            return testName;
        }

        public void setTestName(String testName) {
            this.testName = testName;
        }

        public Long getThemeId() {
            return themeId;
        }

        public void setThemeId(Long themeId) {
            this.themeId = themeId;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        public Long getLevelId() {
            return levelId;
        }

        public void setLevelId(Long levelId) {
            this.levelId = levelId;
        }
    }
}
