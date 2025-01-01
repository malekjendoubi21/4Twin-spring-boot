package tn.esprit.exam.service;

import tn.esprit.exam.entity.ProjetDetail;

import java.util.List;

public interface IProjetDetailService {
    public List<ProjetDetail> retrieveAllProjetDetails();
    public ProjetDetail retrieveProjetDetail(Long idProjetDetail);
    public ProjetDetail addProjetDetail(ProjetDetail projetDetail);
    public void removeProjetDetail(Long idProjetDetail);
    public ProjetDetail modifyProjetDetail(ProjetDetail idProjetDetail);
    
}
