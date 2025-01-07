package tn.esprit.exam.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idQuiz;
    String titre;
    String specialite;

    @Temporal(TemporalType.DATE)
    LocalDate dateQuiz;

@ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
Set<Candidat> candidats = new HashSet<>();


@OneToMany(mappedBy = "quizs" )
Set<Question> questions = new HashSet<>();



}