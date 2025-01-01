package tn.esprit.exam.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.ProjetDetail;
import tn.esprit.exam.service.IProjetDetailService;

import java.util.List;
@Tag(name = "Ce Web Service gère le CRUD pour une ProjetDetail")
@RestController
@AllArgsConstructor
@RequestMapping("/ProjetDetail")
public class ProjetDetailController {
    IProjetDetailService projetDetailService;

    // http://localhost:8089/exam/projetDetail/retrieve-all-projetDetails
    @Operation(description = "Ce web service permet de récupérer toutes les projetDetails de la base de données")
    @GetMapping("/retrieve-all-projetDetails")
    public List<ProjetDetail> getProjetDetails() {
        List<ProjetDetail> listProjetDetails = projetDetailService.retrieveAllProjetDetails();
        return listProjetDetails;
    }
    // http://localhost:8089/exam/projetDetail/retrieve-projetDetail/8
    @GetMapping("/retrieve-projetDetail/{idProjetDetail}")
    public ProjetDetail retrieveProjetDetail(@PathVariable("idProjetDetail") Long chId) {
        ProjetDetail projetDetail = projetDetailService.retrieveProjetDetail(chId);
        return projetDetail;
    }

    // http://localhost:8089/exam/projetDetail/add-projetDetail
    @PostMapping("/add-projetDetail")
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail c) {
        ProjetDetail projetDetail = projetDetailService.addProjetDetail(c);
        return projetDetail;
    }

    // http://localhost:8089/exam/projetDetail/remove-projetDetail/{idProjetDetail}
    @DeleteMapping("/remove-projetDetail/{idProjetDetail}")
    public void removeProjetDetail(@PathVariable("idProjetDetail") Long chId) {
        projetDetailService.removeProjetDetail(chId);
    }

    // http://localhost:8089/exam/projetDetail/modify-projetDetail
    @PutMapping("/modify-projetDetail")
    public ProjetDetail modifyProjetDetail(@RequestBody ProjetDetail c) {
        ProjetDetail projetDetail = projetDetailService.modifyProjetDetail(c);
        return projetDetail;
    }





}