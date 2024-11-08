package tn.esprit.tpfoyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.Entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
