package tn.esprit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.exam.entity.Reponse;

public interface ReponseRepository extends JpaRepository<Reponse, Integer> {
}
