package tn.esprit.exam.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idReponse;
    String libelleR;
@ManyToOne()
Question questions;

}
