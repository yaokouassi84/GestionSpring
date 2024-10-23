package fr.springWeb.service;

import fr.springWeb.model.Etudiant;
import java.util.List;

public interface EtudiantService {

    // Ajouter un nouvel étudiant
    public void ajouterEtudiant(Etudiant etudiant);

    // Mettre à jour les informations d'un étudiant existant
    public void mettreAJourEtudiant(Etudiant etudiant);

    // Supprimer un étudiant par son identifiant
    public void supprimerEtudiant(Long id);

    // Récupérer un étudiant par son identifiant
    public Etudiant obtenirEtudiantParId(Long id);

    // Récupérer la liste de tous les étudiants
    public List<Etudiant> obtenirTousLesEtudiants();
}
