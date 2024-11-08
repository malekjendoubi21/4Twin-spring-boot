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

public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBloc ;
    String nomeBloc ;
    long capaciteBloc ;

    @ManyToOne
    Foyer foyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc")
    private Set<Chambre> chambre;
}
