package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Domaine;
import tn.esprit.exam.entity.Equipe;
import tn.esprit.exam.entity.Projet;
import tn.esprit.exam.entity.ProjetDetail;
import tn.esprit.exam.repository.EquipeRepository;
import tn.esprit.exam.repository.ProjetDetailRepository;
import tn.esprit.exam.repository.ProjetRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProjetService implements IProjetService {
    ProjetRepository projetRepository;
    ProjetDetailRepository projetDetailRepository;
    EquipeRepository equipeRepository;
    @Override
    public List<Projet> retrieveAllProjets() {
        List<Projet> listC = projetRepository.findAll();
        log.info("nombre total des chambres : " + listC.size());
        for (Projet c: listC) {
            log.info("Projet : " + c);
        }
        return listC;
    }

    @Override
    public Projet retrieveProjet(Long idProjet) {


        Projet projet = projetRepository.findById(idProjet).get();
        return projet;
    }

    @Override
    public Projet addProjet(Projet projet) {

        Projet e = projetRepository.save(projet);
        return e;
    }

    @Override
    public void removeProjet(Long idProjet) {
        projetRepository.deleteById(idProjet);
    }

    @Override
    public Projet modifyProjet(Projet idProjet) {

        Projet e = projetRepository.save(idProjet);
        return e;
    }
    public void assignProjetDetailToProjet(Long projetId, Long idProjetDetail) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(idProjetDetail).get();
// on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
// on set le fils dans le parent :
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }

    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }

    public Projet DesaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
// on enlève le fils du parent :
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }
    public void assignMultipleEquipesToProjet(Long projetId, List<Long> equipeIds) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));

        for (Long equipeId : equipeIds) {
            Equipe equipe = equipeRepository.findById(equipeId)
                    .orElseThrow(() -> new IllegalArgumentException("Equipe non trouvée"));
            projet.getEquipes().add(equipe);
            equipe.getProjets().add(projet);
        }

        projetRepository.save(projet);
    }
    public void desaffecterToutesEquipesDeProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));

        for (Equipe equipe : projet.getEquipes()) {
            equipe.getProjets().remove(projet);
        }

        projet.getEquipes().clear();
        projetRepository.save(projet);
    }
    public void desaffecterEquipeDeProjet(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));

        Equipe equipe = equipeRepository.findById(equipeId)
                .orElseThrow(() -> new IllegalArgumentException("Equipe non trouvée"));

        projet.getEquipes().remove(equipe);
        equipe.getProjets().remove(projet);

        projetRepository.save(projet);
    }

    public List<Projet> retrieveProjetsNotAssignedToEquipe(Long equipeId) {
        Equipe equipe = equipeRepository.findById(equipeId)
                .orElseThrow(() -> new IllegalArgumentException("Equipe non trouvée"));
        return projetRepository.findProjetsNotAssignedToEquipe(equipe);
    }
    public void changeProjetDetail(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));

        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId)
                .orElseThrow(() -> new IllegalArgumentException("ProjetDetail non trouvé"));

        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }

    public List<Projet> retrieveProjetsByEquipeDomaine(Domaine domaine) {
        return projetRepository.findProjetsByEquipeDomaine(domaine);
    }


    public Projet addProjetWithDetailAndAssignToEquipes(Projet projet, Long projetDetailId, List<Long> equipeIds) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId)
                .orElseThrow(() -> new IllegalArgumentException("ProjetDetail non trouvé"));
        projet.setProjetDetail(projetDetail);

        for (Long equipeId : equipeIds) {
            Equipe equipe = equipeRepository.findById(equipeId)
                    .orElseThrow(() -> new IllegalArgumentException("Equipe non trouvée"));
            projet.getEquipes().add(equipe);
            equipe.getProjets().add(projet);
        }

        return projetRepository.save(projet);
    }
    public List<Projet> retrieveProjetsWithMultipleEquipes() {
        return projetRepository.findProjetsWithMultipleEquipes();
    }
    public void removeProjetWithDependencies(Long projetId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));

        // Désaffecter les équipes
        for (Equipe equipe : projet.getEquipes()) {
            equipe.getProjets().remove(projet);
        }
        projet.getEquipes().clear();

        // Supprimer le ProjetDetail (si nécessaire)
        if (projet.getProjetDetail() != null) {
            projetDetailRepository.delete(projet.getProjetDetail());
        }

        projetRepository.delete(projet);
    }
    public List<Projet> retrieveProjetsWithHighCost(Long costThreshold) {
        return projetRepository.findProjetsWithHighCost(costThreshold);
    }
    public Double getAverageProjetDurationByDomaine(Domaine domaine) {
        return projetRepository.calculateAverageProjetDurationByDomaine(domaine);
    }
    public List<Projet> retrieveUnassignedProjetsSince(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        Date cutoffDate = calendar.getTime();
        return projetRepository.findUnassignedProjetsSince(cutoffDate);
    }
//Identifie les projets dont les périodes (début-fin) se chevauchent.
    /*public List<Pair<Projet, Projet>> detectOverlappingProjets() {
        List<Object[]> results = projetRepository.findOverlappingProjets();
        return results.stream()
                .map(result -> Pair.of((Projet) result[0], (Projet) result[1]))
                .collect(Collectors.toList());
    }*/
//Retourne les équipes qui gèrent plus d’un certain nombre de projets.
public List<Equipe> retrieveOverloadedEquipes(int threshold) {
    return equipeRepository.findOverloadedEquipes(threshold);
}
//Crée un rapport regroupant les projets par technologie utilisée dans leur ProjetDetail.
public Map<String, Long> generateTechnologieReport() {
    List<Object[]> results = projetRepository.countProjetsByTechnologie();
    return results.stream()
            .collect(Collectors.toMap(
                    result -> (String) result[0],
                    result -> (Long) result[1]
            ));
}

//Retourne les projets d’une équipe dont la date de fin n’a pas encore été atteinte.
/*public List<Projet> retrieveActiveProjetsByEquipe(Long equipeId) {
    return projetRepository.findActiveProjetsByEquipe(equipeId);
}*/
//Retourne le coût total des projets pour chaque domaine d’équipe.
    public Map<Domaine, Long> getTotalCostByDomaine() {
        List<Object[]> results = projetRepository.calculateTotalCostByDomaine();
        return results.stream()
                .collect(Collectors.toMap(
                        result -> (Domaine) result[0],
                        result -> (Long) result[1]
                ));
    }
    public List<Projet> retrieveProjetsWithoutDetails() {
        return projetRepository.findProjetsWithoutDetails();
    }

}
