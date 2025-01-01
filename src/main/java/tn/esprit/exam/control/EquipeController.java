package tn.esprit.exam.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.Equipe;
import tn.esprit.exam.service.IEquipeService;

import java.util.List;

@Tag(name = "Ce Web Service gère le CRUD pour une Equipe")
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {


    IEquipeService equipeService;

    // http://localhost:8089/exam/equipe/retrieve-all-equipes
    @Operation(description = "Ce web service permet de récupérer toutes les equipes de la base de données")
    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getEquipes() {
        List<Equipe> listEquipes = equipeService.retrieveAllEquipes();
        return listEquipes;
    }
    // http://localhost:8089/exam/equipe/retrieve-equipe/8
    @GetMapping("/retrieve-equipe/{idEquipe}")
    public Equipe retrieveEquipe(@PathVariable("idEquipe") Long chId) {
        Equipe equipe = equipeService.retrieveEquipe(chId);
        return equipe;
    }

    // http://localhost:8089/exam/equipe/add-equipe
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe c) {
        Equipe equipe = equipeService.addEquipe(c);
        return equipe;
    }

    // http://localhost:8089/exam/equipe/remove-equipe/{idEquipe}
    @DeleteMapping("/remove-equipe/{idEquipe}")
    public void removeEquipe(@PathVariable("idEquipe") Long chId) {
        equipeService.removeEquipe(chId);
    }

    // http://localhost:8089/exam/equipe/modify-equipe
    @PutMapping("/modify-equipe")
    public Equipe modifyEquipe(@RequestBody Equipe c) {
        Equipe equipe = equipeService.modifyEquipe(c);
        return equipe;
    }
    
    
    
    
    
}
