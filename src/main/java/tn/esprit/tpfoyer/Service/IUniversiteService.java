package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public Universite addUniversite(Universite universite);
    public Universite updateUniversite(Universite universite);
    public List<Universite> retrieUniversiteAllUniversite();
    public Universite retrieUniversiteById(Long idUniversite);
    public void DeleteUniversite(Long idUniversite);
    public Universite affectationfoyer ( long idf , long idu );

}
