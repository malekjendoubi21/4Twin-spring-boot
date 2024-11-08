package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v2")
public class ChambreController {
    private IChambreService ichambreService;
    @GetMapping("/chambre")
    public List<Chambre> getChambre() {return ichambreService.retrieChambreAllchambre();
    }

    @PostMapping("/addchambre")
    public Chambre addChambre(@RequestBody Chambre chambre )
    {
        return  ichambreService.addChambre(chambre);

    }
    @PutMapping("/UpdateChambre")
    public Chambre UpdateChambre ( @RequestBody Chambre chambre) {
        return ichambreService.updateChambre(chambre);
    }

    @GetMapping("/retriechambreById/{idChambre}")
    public Chambre retriechambreById(@PathVariable Long idChambre) {
        return ichambreService.retriechambreById(idChambre);
    }
    @DeleteMapping("/deleteChambre/{idChambre}")

    public void  DeleteChambre( @PathVariable Long idChambre) {
        ichambreService.Deletechambre(idChambre); }



}
