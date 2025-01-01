package tn.esprit.exam.repository;

import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail, Long> {
}
