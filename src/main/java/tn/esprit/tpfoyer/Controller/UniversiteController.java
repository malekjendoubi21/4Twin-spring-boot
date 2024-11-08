package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Universite;
import tn.esprit.tpfoyer.Service.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")

@RequestMapping("/api/v6")
public class UniversiteController {
    private IUniversiteService iuniversiteService;

    @GetMapping("/reservation")
    public List<Universite> getfoyer(){
        return iuniversiteService.retrieUniversiteAllUniversite();
    }



    @PostMapping("/addreservation")
    public Universite addFoyer(@RequestBody Universite universite )
    {
        return  iuniversiteService.addUniversite(universite);

    }

    @PutMapping("/UpdateReservation")

    public Universite UpdateReservation ( @RequestBody Universite universite) {
        return iuniversiteService.updateUniversite(universite);
    }

    @GetMapping("/retiReservationById/{IdUniversite}")
    public Universite retriReservationById(@PathVariable Long IdUniversite) {
        return iuniversiteService.retrieUniversiteById(IdUniversite);
    }
    @DeleteMapping("/deleteFoyer/{IdUniversite}")

    public void  DeleteReservation( @PathVariable Long IdUniversite) {
        iuniversiteService.DeleteUniversite(IdUniversite); }


    @PostMapping("/affectationfoyer/{idf}/{idu}")
     public  Universite affectationfoyer(@PathVariable long idf ,@PathVariable long idu  ){

        return iuniversiteService.affectationfoyer(idf,idu);
}

}
