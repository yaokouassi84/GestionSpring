package fr.springWeb.dao;

import fr.springWeb.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EtudiantDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EtudiantDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Etudiant> obtenirTousLesEtudiants() {
        String sql = "SELECT * FROM etudiant";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(rs.getLong("id"));
            etudiant.setNom(rs.getString("nom"));
            etudiant.setPrenom(rs.getString("prenom"));
            etudiant.setEmail(rs.getString("email"));
            etudiant.setDateDeNaissance(rs.getDate("date_naissance"));
            return etudiant;
        });
    }

    // Autres méthodes CRUD pour gérer les étudiants...
}
