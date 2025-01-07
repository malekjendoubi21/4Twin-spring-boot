package tn.esprit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.exam.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
