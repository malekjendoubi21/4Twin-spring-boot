package tn.esprit.exam.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.Projet;
import tn.esprit.exam.service.IProjetService;

import java.util.List;
@Tag(name = "Ce Web Service gère le CRUD pour une Projet")
@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetController {

    IProjetService projetService;

    // http://localhost:8089/exam/projet/retrieve-all-projets
    @Operation(description = "Ce web service permet de récupérer toutes les projets de la base de données")
    @GetMapping("/retrieve-all-projets")
    public List<Projet> getProjets() {
        List<Projet> listProjets = projetService.retrieveAllProjets();
        return listProjets;
    }
    // http://localhost:8089/exam/projet/retrieve-projet/8
    @GetMapping("/retrieve-projet/{idProjet}")
    public Projet retrieveProjet(@PathVariable("idProjet") Long chId) {
        Projet projet = projetService.retrieveProjet(chId);
        return projet;
    }

    // http://@localhost:8089/exam/projet/add-projet
    @PostMapping("/add-projet")
    public Projet addProjet(@RequestBody Projet c) {
        Projet projet = projetService.addProjet(c);
        return projet;
    }

    // http://localhost:8089/exam/projet/remove-projet/{idProjet}
    @DeleteMapping("/remove-projet/{idProjet}")
    public void removeProjet(@PathVariable("idProjet") Long chId) {
        projetService.removeProjet(chId);
    }

    // http://localhost:8089/exam/projet/modify-projet
    @PutMapping("/modify-projet")
    public Projet modifyProjet(@RequestBody Projet c) {
        Projet projet = projetService.modifyProjet(c);
        return projet;
    }

    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecgterProjetAProjetDetail(@PathVariable ("projet-id") Long proejtId, @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetService.assignProjetDetailToProjet(proejtId, proejtDetailsId);
    }

    @PutMapping("/affecter-projet-a-equipe/{projet-id}/{equipeId}")
    public void assignProjetToEquipe(@PathVariable ("projet-id") Long projetId, @PathVariable("equipeId") Long equipeId) {
        projetService.assignProjetToEquipe(projetId, equipeId);
    }

  @PostMapping("/addProjetAndAssignProjetToProjetDetail/{projetDetailId}")
   public void  addProjetAndAssignProjetToProjetDetail(@RequestBody Projet p, @PathVariable("projetDetailId") Long projetDetailId) {
        projetService.addProjetAndAssignProjetToProjetDetail(p, projetDetailId);
    }

    @PutMapping("/DesaffecterProjetDetailFromProjet/{projetId}")
    public void DesaffecterProjetDetailFromProjet(@PathVariable("projetId") Long projetId) {
        projetService.DesaffecterProjetDetailFromProjet(projetId);
    }

 @PutMapping("/desaffecterProjetFromEquipe/{projetId}/{equipeId}")
    public void desaffecterProjetFromEquipe(@PathVariable("projetId") Long projetId, @PathVariable("equipeId") Long equipeId) {
        projetService.desaffecterProjetFromEquipe(projetId, equipeId);
    }





}