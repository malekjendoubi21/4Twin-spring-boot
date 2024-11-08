package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Service.IFoyerService;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")

@RequestMapping("/api/v1")
public class FoyerController {
    private IFoyerService ifoyerService;


    @GetMapping("/foyer")
    public List<Foyer> getfoyer(){
        return ifoyerService.retrieFoyerAllFoyer();
    }



    @PostMapping("/addfoyer")
    public Foyer addFoyer(@RequestBody Foyer foyer )
    {
        return  ifoyerService.addFoyer(foyer);

    }

       @PutMapping("/UpdateFoyer")

       public Foyer UpdateFoyer ( @RequestBody Foyer foyer) {
           return ifoyerService.updateFoyer(foyer);
       }

    @GetMapping("/retiFoyerById/{idF}")
    public Foyer retriFoyerById(@PathVariable Long idF) {
        return ifoyerService.retrieFoyerById(idF);
    }
    @DeleteMapping("/deleteFoyer/{idF}")

    public void  DeleteFoyer( @PathVariable Long idF) {
        ifoyerService.DeleteFoyer(idF); }



}
