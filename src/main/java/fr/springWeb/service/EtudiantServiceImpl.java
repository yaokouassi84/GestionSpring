package fr.springWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.springWeb.model.Etudiant;

public class EtudiantServiceImpl implements EtudiantService {

  
    private List<Etudiant> etudiants = new ArrayList<>();
    
    private Long compteurId = 1L; 

    @Override
    public void ajouterEtudiant(Etudiant etudiant) {
        
        etudiant.setId(compteurId++);
        etudiants.add(etudiant);
        System.out.println("Étudiant ajouté : " + etudiant);
    }

    @Override
    public void mettreAJourEtudiant(Etudiant etudiant) {
        
        Optional<Etudiant> etudiantExistant = etudiants.stream()
                .filter(e -> e.getId().equals(etudiant.getId()))
                .findFirst();
        
        if (etudiantExistant.isPresent()) {
            int index = etudiants.indexOf(etudiantExistant.get());
            etudiants.set(index, etudiant);
            System.out.println("Étudiant mis à jour : " + etudiant);
        } else {
            System.out.println("Étudiant non trouvé pour la mise à jour : " + etudiant.getId());
        }
    }

    @Override
    public void supprimerEtudiant(Long id) {
        
        etudiants.removeIf(e -> e.getId().equals(id));
        System.out.println("Étudiant supprimé avec ID : " + id);
    }

    @Override
    public Etudiant obtenirEtudiantParId(Long id) {
        
        return etudiants.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Etudiant> obtenirTousLesEtudiants() {
        
        return new ArrayList<>(etudiants);
    }
}
