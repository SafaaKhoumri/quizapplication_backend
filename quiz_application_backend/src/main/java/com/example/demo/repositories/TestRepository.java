package com.example.demo.repositories;

import com.example.demo.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    // Vous pouvez ajouter d'autres méthodes de requête ici si nécessaire
}
