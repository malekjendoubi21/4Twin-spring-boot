package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Equipe;
import tn.esprit.exam.entity.Projet;
import tn.esprit.exam.entity.ProjetDetail;
import tn.esprit.exam.repository.EquipeRepository;
import tn.esprit.exam.repository.ProjetDetailRepository;
import tn.esprit.exam.repository.ProjetRepository;

import java.util.List;

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


}
