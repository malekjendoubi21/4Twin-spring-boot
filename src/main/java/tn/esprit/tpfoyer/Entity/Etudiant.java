package tn.esprit.tpfoyer.Entity;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idEtudiant;
     String nom;
     String prenom;
     long Cin;
     String ecole;
     Date dateNaiss;

     @ManyToMany(mappedBy="etudiant", cascade = CascadeType.ALL)
     private Set<Reservation> reservation;

}
