package com.example.demo.controllers;

import com.example.demo.model.Theme;
import com.example.demo.model.Role;
import com.example.demo.model.Competence;
import com.example.demo.model.Level;
import com.example.demo.model.Test;
import com.example.demo.repositories.TestRepository;
import com.example.demo.repositories.ThemeRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.CompetenceRepository;
import com.example.demo.repositories.NiveauRepository;
import com.example.demo.repositories.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CreateTestController {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private NiveauRepository levelRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private AdministrateurRepository administrateurRepository;

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

    // Endpoint pour rechercher des compétences par nom, thème, rôle et niveau
    @GetMapping("/competencies/search")
    public List<Competence> searchCompetencies(
            @RequestParam String query,
            @RequestParam Long themeId,
            @RequestParam Long roleId,
            @RequestParam Long levelId) {
        return competenceRepository.findByNameContainingIgnoreCaseAndThemeIdAndRoleIdAndLevelId(query, themeId, roleId,
                levelId);
    }

    // Endpoint pour créer un nouveau test
    @PostMapping("/createTest")
    public void createTest(@RequestBody TestRequest testRequest) {
        Test test = new Test();
        test.setNametest(testRequest.getTestName());
        test.setTheme(themeRepository.findById(testRequest.getThemeId()).orElse(null));
        test.setRole(roleRepository.findById(testRequest.getRoleId()).orElse(null));
        test.setLevel(levelRepository.findById(testRequest.getLevelId()).orElse(null));
        test.setCompetences(competenceRepository.findAllById(testRequest.getCompetenceIds()));
        test.setAdministrator(administrateurRepository.findById(testRequest.getAdminId()).orElse(null));

        testRepository.save(test);
    }

    // Classe interne pour encapsuler les informations de création de test
    public static class TestRequest {
        private String testName;
        private Long themeId;
        private Long roleId;
        private Long levelId;
        private List<Long> competenceIds;
        private Long adminId;

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

        public List<Long> getCompetenceIds() {
            return competenceIds;
        }

        public void setCompetenceIds(List<Long> competenceIds) {
            this.competenceIds = competenceIds;
        }

        public Long getAdminId() {
            return adminId;
        }

        public void setAdminId(Long adminId) {
            this.adminId = adminId;
        }
    }
}
