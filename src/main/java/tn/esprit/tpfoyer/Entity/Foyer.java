package tn.esprit.tpfoyer.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    long capaciteFoyer;


    @OneToOne
    private Universite universite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    private Set<Bloc> bloc;

}
