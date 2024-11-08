package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.Entity.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public Etudiant addEtudiant(Etudiant etudiant);

    public Etudiant updateEtudiant(Etudiant etudiant);

    public List<Etudiant> retrieEtudianteAlletudiant();

    public Etudiant retrieEtudianteById(Long idEtudiant );

    public void DeleteEtudiant(Long idEtudiant);
}

