package tn.esprit.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idQuestion;
    String LibelleQ ;
    Complexite complexite;

    @ManyToOne(cascade = CascadeType.ALL)
    Quiz quizs;


    @OneToMany(mappedBy = "questions" ,cascade = CascadeType.ALL)
            @JsonIgnore
    @ToString.Exclude
    Set<Reponse> reponses=new HashSet<>();


}
