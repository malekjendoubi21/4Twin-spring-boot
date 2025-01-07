package tn.esprit.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Candidat {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCandidat;

    String nom ;
    String prenom;
    int nbQuiz;

    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToMany(mappedBy = "candidats")
    @ToString.Exclude
    @JsonIgnore
    Set<Quiz> quizs = new HashSet<>();


}
