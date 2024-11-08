package tn.esprit.tpfoyer.Service;


import tn.esprit.tpfoyer.Entity.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer addFoyer(Foyer foyer);
    public Foyer updateFoyer(Foyer foyer);
    public List<Foyer> retrieFoyerAllFoyer();
    public Foyer retrieFoyerById(Long idF);
    public void DeleteFoyer(Long idF);
}
