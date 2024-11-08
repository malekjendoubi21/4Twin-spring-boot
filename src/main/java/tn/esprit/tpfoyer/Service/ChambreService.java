package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Repository.ChambreRepository;

import java.util.List;
@Data
@AllArgsConstructor
@Service
public class ChambreService implements IChambreService{
    private ChambreRepository chambreRepository;
    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.saveAndFlush(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> retrieChambreAllchambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retriechambreById(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void Deletechambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);

    }
}
