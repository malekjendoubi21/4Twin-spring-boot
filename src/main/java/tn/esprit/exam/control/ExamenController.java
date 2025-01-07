package tn.esprit.exam.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.Candidat;
import tn.esprit.exam.entity.Niveau;
import tn.esprit.exam.entity.Question;
import tn.esprit.exam.entity.Quiz;

import tn.esprit.exam.service.Iserviceexam;

import java.util.List;

@Tag(name = "Ce Web Service gère le CRUD pour une Projet")
@RestController
@AllArgsConstructor
@RequestMapping("/exam")
public class ExamenController {
Iserviceexam serviceexam;
//	@PostMapping("/add")

    @PostMapping("/add")
    public Candidat ajouterCandidat(@RequestBody  Candidat candidat) {
        return serviceexam.ajouterCandidat(candidat);
    }

    @PostMapping("/addquiz")
    public Quiz ajouterQuiz(@RequestBody  Quiz quiz) {
        return serviceexam.ajouterQuiz(quiz);
    }
    @PutMapping("/affecterQuizCandidat/{titreQuiz}/{idCandidat}")
    public Quiz affecterQuizCandidat(@PathVariable ("titreQuiz")  String titreQuiz,@PathVariable("idCandidat") Integer idCandidat) {
        return serviceexam.affecterQuizCandidat(titreQuiz, idCandidat);
    }
@GetMapping("/recupererCandidat/{specialite}/{niveau}")
    public List<Candidat > recupererCandidat(@PathVariable ("specialite") String specialite,@PathVariable ("niveau") Niveau niveau) {
        return serviceexam.recupererCandidat(specialite, niveau);
    }

@PostMapping("/ajouterQuestEtRepEtAffecterQuestAQuiz{idQuiz}")
    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(@RequestBody  Question question, @PathVariable ("idQuiz")  Integer idQuiz) {
        return serviceexam.ajouterQuestEtRepEtAffecterQuestAQuiz(question, idQuiz);
    }

}
