package tn.esprit.exam.service;

import tn.esprit.exam.entity.Equipe;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> retrieveAllEquipes();
    public Equipe retrieveEquipe(Long idEquipe);
    public Equipe addEquipe(Equipe equipe);
    public void removeEquipe(Long idEquipe);
    public Equipe modifyEquipe(Equipe idEquipe);
}
