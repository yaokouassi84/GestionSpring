package fr.springWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DatabaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test-connection")
    public String testConnection() {
        try {
            // Exemple de requête pour tester la connexion
            String sql = "SELECT * FROM v$database"; // Cette requête récupère le nom de la base de données
            String databaseName = jdbcTemplate.queryForObject(sql, String.class);
            return "Nom de la base de données : " + databaseName;
        } catch (Exception e) {
            return "Erreur de connexion : " + e.getMessage();
        }
    }
}
