package tn.esprit.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idProjet;
String sujet;
    @OneToOne(cascade = CascadeType.ALL)
    private ProjetDetail projetDetail;

    @ManyToMany(mappedBy = "projets", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Set<Equipe> equipes = new HashSet<>();
}
