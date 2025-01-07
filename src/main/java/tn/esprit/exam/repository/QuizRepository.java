package tn.esprit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.exam.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
Quiz findByTitre(String titre);
}
