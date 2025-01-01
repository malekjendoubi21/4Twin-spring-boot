package tn.esprit.exam.service;

import tn.esprit.exam.entity.Projet;

import java.util.List;

public interface IProjetService {
    public List<Projet> retrieveAllProjets();
    public Projet retrieveProjet(Long idProjet);
    public Projet addProjet(Projet projet);
    public void removeProjet(Long idProjet);
    public Projet modifyProjet(Projet idProjet);
    public void assignProjetDetailToProjet(Long projetId, Long idProjetDetail) ;
    public void assignProjetToEquipe(Long projetId, Long equipeId);
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) ;
    public Projet DesaffecterProjetDetailFromProjet(Long projetId) ;
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) ;

    }
