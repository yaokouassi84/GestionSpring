package fr.springWeb.controllers;

import fr.springWeb.model.Etudiant;
import fr.springWeb.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/etudiants") 
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // Méthode pour obtenir tous les étudiants
    @GetMapping
    @ResponseBody // Pour retourner les données sous forme de JSON
    public List<Etudiant> obtenirTousLesEtudiants() {
        return etudiantService.obtenirTousLesEtudiants();
    }

    // Méthode pour ajouter un nouvel étudiant
    @PostMapping
    @ResponseBody
    public void ajouterEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.ajouterEtudiant(etudiant);
    }

    // Méthode pour mettre à jour un étudiant
    @PutMapping("/{id}")
    @ResponseBody
    public void mettreAJourEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        etudiant.setId(id); // Assurez-vous que l'ID est mis à jour
        etudiantService.mettreAJourEtudiant(etudiant);
    }

    // Méthode pour supprimer un étudiant
    @DeleteMapping("/{id}")
    @ResponseBody
    public void supprimerEtudiant(@PathVariable Long id) {
        etudiantService.supprimerEtudiant(id);
    }

    // Méthode pour obtenir un étudiant par son ID
    @GetMapping("/{id}")
    @ResponseBody
    public Etudiant obtenirEtudiantParId(@PathVariable Long id) {
        return etudiantService.obtenirEtudiantParId(id);
    }
}

