package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Entity.Universite;
import tn.esprit.tpfoyer.Repository.FoyerRepository;
import tn.esprit.tpfoyer.Repository.UniversiteRepository;

import java.util.List;
@Data
@Service
@RequiredArgsConstructor
public class UniversiteService implements IUniversiteService {
    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;
    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.saveAndFlush(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> retrieUniversiteAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieUniversiteById(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null)  ;
    }

    @Override
    public void DeleteUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
    @Override

    public Universite affectationfoyer ( long idf , long idu )
    {
        Foyer foyer = foyerRepository.findById(idf).orElse(null);
        Universite universite = universiteRepository.findById( idu ).orElse(null);
        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }


}
