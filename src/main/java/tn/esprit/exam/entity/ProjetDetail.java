package tn.esprit.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idProjetDetail;
    String description;
    String technologie;
    long coud ;
    @Temporal(TemporalType.DATE)
    Date dateDebut;

    @OneToOne(mappedBy = "projetDetail" , cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private  Projet projet ;

}
