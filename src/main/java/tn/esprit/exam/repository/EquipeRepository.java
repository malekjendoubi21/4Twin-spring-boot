package tn.esprit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Domaine;
import tn.esprit.exam.entity.Equipe;
import tn.esprit.exam.entity.Projet;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    @Query("SELECT e FROM Equipe e WHERE SIZE(e.projets) > :threshold")
    List<Equipe> findOverloadedEquipes(@Param("threshold") int threshold);

    Equipe findEquipeByNom(String nom);
    List<Equipe> findByDomaine(Domaine domaine);
    List<Equipe> findByProjetsSizeGreaterThan(int size);
    Equipe findByProjetsContaining(Projet projet);
    List<Equipe> findByProjetsNotContaining(Projet projet);
    List<Equipe> findByProjetsEmpty();
    List<Equipe> findByProjetsNotEmpty();
    List<Equipe> findByProjetsIsNull();
    List<Equipe> findByProjetsIsNotNull();
    List<Equipe> findByProjetsIsNotNullAndDomaine(Domaine domaine);
    List<Equipe> findByProjetsIsNotNullAndDomaineNot(Domaine domaine);
    List<Equipe> findByProjetsIsNotNullAndDomaineNotIn(List<Domaine> domaines);
    List<Equipe> findByProjetsIsNotNullAndDomaineIn(List<Domaine> domaines);
    List<Equipe> findByProjetsIsNotNullAndDomaineNotInAndProjetsSizeGreaterThan(List<Domaine> domaines, int size);
    List<Equipe> findByProjetsIsNotNullAndDomaineInAndProjetsSizeGreaterThan(List<Domaine> domaines, int size);
    List<Equipe> findByProjetsIsNotNullAndDomaineNotInAndProjetsSizeGreaterThanAndNomContaining(List<Domaine> domaines, int size, String nom);
    List<Equipe> findByProjetsIsNotNullAndDomaineInAndProjetsSizeGreaterThanAndNomContaining(List<Domaine> domaines, int size, String nom);
}
