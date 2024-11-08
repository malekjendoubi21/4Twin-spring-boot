package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Service.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")

@RequestMapping("/api/v3")
public class BlocController {
    private IBlocService iblocService;
    @GetMapping("/bloc")
    public List<Bloc> getBloc(){
        return iblocService.retrieBlocAllBloc();
    }



    @PostMapping("/addbloc")
    public Bloc addBloc(@RequestBody Bloc bloc )
    {
        return  iblocService.addBloc(bloc);

    }

    @PutMapping("/UpdateBloc")
    public Bloc UpdateFoyer ( @RequestBody Bloc bloc) {
        return iblocService.updateBloc(bloc);
    }

    @GetMapping("/retiBlocyId/{idBloc}")
    public Bloc retriBlocById(@PathVariable Long idBloc ) {
        return iblocService.retrieBlocById(idBloc);
    }
    @DeleteMapping("/deleteBloc/{idBloc}")

    public void  DeleteBloc( @PathVariable Long idBloc) {
        iblocService.DeleteBloc(idBloc); }

}
