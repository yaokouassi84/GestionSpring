package fr.springWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.springWeb.model.Etudiant;
import fr.springWeb.service.EtudiantService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/etudiants")
public class IndexControlleur {

	@Autowired
	private EtudiantService etudiantService;

	@GetMapping
	public String obtenirTousLesEtudiants(Model model) {
		List<Etudiant> etudiants = etudiantService.obtenirTousLesEtudiants();
		model.addAttribute("etudiants", etudiants);
		return "listeEtudiants"; // Une vue qui affiche la liste des étudiants
	}

	@PostMapping("/ajouter")
	public String ajouterEtudiant(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
			@RequestParam("email") String email, @RequestParam("dateNaissance") Date dateNaissance) {

		Etudiant etudiant = new Etudiant(null, nom, prenom, email, dateNaissance);
		etudiantService.ajouterEtudiant(etudiant);
		return "redirect:/etudiants";
	}
}
