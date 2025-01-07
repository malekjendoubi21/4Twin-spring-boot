package tn.esprit.exam.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.exam.entity.Candidat;
import tn.esprit.exam.entity.Niveau;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat,Integer> {

    List<Candidat> findByQuizsSpecialiteAndNiveauAndQuizsDateQuizAfter(String specialite, Niveau niveau , LocalDate dateQuiz);
}
