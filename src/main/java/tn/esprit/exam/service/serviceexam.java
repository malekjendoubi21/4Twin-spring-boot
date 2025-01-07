package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Candidat;
import tn.esprit.exam.entity.Niveau;
import tn.esprit.exam.entity.Question;
import tn.esprit.exam.entity.Quiz;
import tn.esprit.exam.repository.CandidatRepository;
import tn.esprit.exam.repository.QuizRepository;

import java.time.LocalDate;
import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class serviceexam implements Iserviceexam {
    CandidatRepository candidatRepository;
    QuizRepository quizRepository;
    @Override
    public Candidat ajouterCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    @Override
    public Quiz ajouterQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat) {
        Candidat candidat = candidatRepository.findById(idCandidat).get();
            Quiz quiz = quizRepository.findByTitre(titreQuiz);
            quiz.getCandidats().add(candidat);
             candidat.setNbQuiz(candidat.getNbQuiz()+1);
             quizRepository.save(quiz);
             return quiz ;
                       }

    @Override
    public List<Candidat> recupererCandidat(String specialite, Niveau niveau) {

        LocalDate dateQuiz = LocalDate.now();
        return candidatRepository.findByQuizsSpecialiteAndNiveauAndQuizsDateQuizAfter(specialite, niveau, dateQuiz);
    }

    @Override
    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(Question question, Integer idQuiz) {
       Quiz quiz = quizRepository.findById(idQuiz).get();
         question.setQuizs(quiz);
            return question;
    }



}
