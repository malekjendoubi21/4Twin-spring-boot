package tn.esprit.tpfoyer.Service;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Repository.FoyerRepository;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class FoyerService  implements IFoyerService {
    private FoyerRepository foyerRepository;
    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.saveAndFlush(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return  foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> retrieFoyerAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieFoyerById(Long idF) {
        return foyerRepository.findById(idF).orElse(null) ;
    }

    @Override
    public void DeleteFoyer(Long idF) {
        foyerRepository.deleteById(idF);

    }
}

