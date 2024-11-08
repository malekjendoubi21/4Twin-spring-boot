package tn.esprit.tpfoyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.Entity.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
