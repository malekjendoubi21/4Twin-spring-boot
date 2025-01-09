package tn.esprit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Domaine;
import tn.esprit.exam.entity.Equipe;
import tn.esprit.exam.entity.Projet;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Query("SELECT p FROM Projet p WHERE :equipe NOT MEMBER OF p.equipes")
    List<Projet> findProjetsNotAssignedToEquipe(@Param("equipe") Equipe equipe);
    @Query("SELECT DISTINCT p FROM Projet p JOIN p.equipes e WHERE e.domaine = :domaine")
    List<Projet> findProjetsByEquipeDomaine(@Param("domaine") Domaine domaine);
    @Query("SELECT p FROM Projet p WHERE SIZE(p.equipes) > 1")
    List<Projet> findProjetsWithMultipleEquipes();
    @Query("SELECT p FROM Projet p WHERE p.projetDetail.coud > :costThreshold")
    List<Projet> findProjetsWithHighCost(@Param("costThreshold") Long costThreshold);
    @Query("SELECT AVG(DATEDIFF(p.projetDetail.dateDebut, CURRENT_DATE)) " +
            "FROM Projet p JOIN p.equipes e WHERE e.domaine = :domaine")
    Double calculateAverageProjetDurationByDomaine(@Param("domaine") Domaine domaine);
    @Query("SELECT p FROM Projet p WHERE SIZE(p.equipes) = 0 AND p.projetDetail.dateDebut < :cutoffDate")
    List<Projet> findUnassignedProjetsSince(@Param("cutoffDate") Date cutoffDate);
   /* @Query("SELECT p1, p2 FROM Projet p1, Projet p2 " +
            "WHERE p1.idProjet <> p2.idProjet " +
            "AND p1.projetDetail.dateDebut <= p2.projetDetail.dateDebut " +
            "AND p1.projetDetail.dateFin >= p2.projetDetail.dateDebut")
    List<Object[]> findOverlappingProjets();*/
    @Query("SELECT p.projetDetail.technologie, COUNT(p) " +
            "FROM Projet p GROUP BY p.projetDetail.technologie")
    List<Object[]> countProjetsByTechnologie();
   /* @Query("SELECT p FROM Projet p JOIN p.equipes e " +
            "WHERE e.idEquipe = :equipeId AND p.projetDetail.dateFin > CURRENT_DATE")
    List<Projet> findActiveProjetsByEquipe(@Param("equipeId") Long equipeId);*/
    @Query("SELECT e.domaine, SUM(p.projetDetail.coud) " +
            "FROM Projet p JOIN p.equipes e GROUP BY e.domaine")
    List<Object[]> calculateTotalCostByDomaine();
    @Query("SELECT p FROM Projet p WHERE p.projetDetail IS NULL")
    List<Projet> findProjetsWithoutDetails();


    Projet findProjetBySujet(String sujet);
    List<Projet> findByProjetDetail_CoudGreaterThan(Long cost);
    List<Projet> findByEquipes_IdEquipe(Long idEquipe);
    List<Projet> findByProjetDetail_DateDebutAfter(Date startDate);
    List<Projet> findByProjetDetail_DateDebutBefore(Date endDate);
    List<Projet> findByProjetDetail_DateDebutBetween(Date startDate, Date endDate);
    List<Projet> findByProjetDetail_DateDebutBetweenAndProjetDetail_DateFinBetween(Date start1, Date end1, Date start2, Date end2);
    List<Projet> findByProjetDetail_DateDebutBetweenOrProjetDetail_DateFinBetween(Date start1, Date end1, Date start2, Date end2);
    List<Projet> findByProjetDetail_DateDebutBetweenAndProjetDetail_DateFinBetweenOrProjetDetail_DateFinBetween(Date start1, Date end1, Date start2, Date end2, Date end3);
    List<Projet> findByProjetDetail_DateDebutBetweenOrProjetDetail_DateFinBetweenAndProjetDetail_DateFinBetween(Date start1, Date end1, Date start2, Date end2, Date end3);

}
