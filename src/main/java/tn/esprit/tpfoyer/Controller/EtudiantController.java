package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Etudiant;
import tn.esprit.tpfoyer.Service.IEtudiantService;
import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin("*")

@RequestMapping("/api/v4")
public class EtudiantController {
    private IEtudiantService ietudiantService;
    @GetMapping("/etudiant")
    public List<Etudiant> getetudiant(){
        return ietudiantService.retrieEtudianteAlletudiant();
    }

    @PostMapping("/addetudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant )
    {
        return  ietudiantService.addEtudiant(etudiant);

    }

    @PutMapping("/UpdateEtudiant")

    public Etudiant UpdateEtudiant ( @RequestBody Etudiant etudiant) {
        return ietudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/retiEtudiantById/{idEtudiants}")
    public Etudiant retriEtudiantById(@PathVariable Long IdEtudiant ) {
        return ietudiantService.retrieEtudianteById(IdEtudiant);
    }
    @DeleteMapping("/deleteFoyer/{idF}")

    public void  DeleteFoyer( @PathVariable Long IdEtudiant) {
        ietudiantService.DeleteEtudiant(IdEtudiant); }


}
