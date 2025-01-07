package tn.esprit.exam.service;

import tn.esprit.exam.entity.Candidat;
import tn.esprit.exam.entity.Niveau;
import tn.esprit.exam.entity.Question;
import tn.esprit.exam.entity.Quiz;

import java.util.List;

public interface Iserviceexam {
    public Candidat ajouterCandidat(Candidat candidat) ;
    public Quiz ajouterQuiz(Quiz quiz) ;
    public Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat) ;
    public List<Candidat> recupererCandidat (String specialite, Niveau niveau) ;
    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(Question question,
                                                          Integer idQuiz) ;


}
