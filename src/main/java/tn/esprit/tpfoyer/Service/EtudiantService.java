package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Etudiant;
import tn.esprit.tpfoyer.Repository.EtudiantRepository;

import java.util.List;
@Data
@AllArgsConstructor
@Service
public class EtudiantService implements IEtudiantService{
    private EtudiantRepository etudiantRepository;
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.saveAndFlush(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> retrieEtudianteAlletudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieEtudianteById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void DeleteEtudiant(Long idEtudiant) {
      etudiantRepository.deleteById(idEtudiant);
    }
}
