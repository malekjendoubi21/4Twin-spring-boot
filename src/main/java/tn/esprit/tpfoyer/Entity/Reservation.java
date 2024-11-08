package tn.esprit.tpfoyer.Entity;

import java.util.Date;
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

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReservation;  
    Date anneeUniversitaire;
    boolean estValide;

    @ManyToOne
    Chambre chambre;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiant;

}
