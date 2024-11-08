package tn.esprit.tpfoyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.Entity.Bloc;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
}
